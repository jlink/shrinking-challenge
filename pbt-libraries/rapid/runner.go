// Copyright 2022 Gregory Petrosyan <gregory.petrosyan@gmail.com>
//
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at https://mozilla.org/MPL/2.0/.

package main

import (
	"bufio"
	"encoding/json"
	"errors"
	"flag"
	"fmt"
	"log"
	"os"
	"os/exec"
	"path/filepath"
	"regexp"
	"sort"
	"strconv"
	"strings"
	"text/template"
)

const (
	rapidName    = "rapid"
	rapidVersion = "v0.4.7"

	reportsDir     = "reports"
	reportsDirPerm = 0755
	reportPerm     = 0644
	failMarker     = "--- FAIL: "
	maxShrinks     = 10
)

var (
	seedRe = regexp.MustCompile(`-rapid\.seed=(\d+)`)
	drawRe = regexp.MustCompile(`\[rapid] draw (\w+): (.*)`)

	reportTmpl = template.Must(template.ParseFiles("report.md.tmpl"))
)

type (
	result struct {
		Seed   string            `json:"seed"`
		Shrunk map[string]string `json:"shrunk"`
	}

	templateData struct {
		TestName       string
		LibraryName    string
		LibraryVersion string
		DistinctCount  int
		TotalCount     int
		Shrinks        []templateShrink
	}

	templateShrink struct {
		Shrink        string
		ShrinkPercent float64
	}

	shrinkCount struct {
		n  int
		ix int
	}
)

func runTests(test string, count int) ([]result, error) {
	data, err := exec.Command("go", "test", "-run", test, "-count", strconv.Itoa(count), "-rapid.nofailfile", "-rapid.checks", "10000").Output()
	var exitErr *exec.ExitError
	if !errors.As(err, &exitErr) || exitErr.ExitCode() != 1 {
		return nil, fmt.Errorf("unexpected test error: %w", err)
	}

	var allDraws []result
	fails := strings.Split(string(data), failMarker)
	for _, f := range fails {
		if f == "" {
			continue
		}
		seed := seedRe.FindStringSubmatch(f)
		draws := drawRe.FindAllStringSubmatch(f, -1)
		r := result{
			Seed:   seed[1],
			Shrunk: map[string]string{},
		}
		for _, draw := range draws {
			r.Shrunk[draw[1]] = draw[2]
		}
		allDraws = append(allDraws, r)
	}

	return allDraws, nil
}

func shrinkStr(m map[string]string) string {
	var ks []string
	for k := range m {
		ks = append(ks, k)
	}
	sort.Strings(ks)
	var vs []string
	for _, k := range ks {
		vs = append(vs, m[k])
	}
	return strings.Join(vs, ", ")
}

func analyze(report string, res []result) (templateData, error) {
	counts := map[string]shrinkCount{}
	distinct := 0
	for i, r := range res {
		s := shrinkStr(r.Shrunk)
		e := counts[s]
		if e.n == 0 {
			distinct++
			counts[s] = shrinkCount{n: 1, ix: i}
		} else {
			counts[s] = shrinkCount{n: e.n + 1, ix: e.ix}
		}
	}

	var sorted []shrinkCount
	for _, e := range counts {
		sorted = append(sorted, e)
	}
	sort.Slice(sorted, func(i, j int) bool { return sorted[i].n > sorted[j].n })

	var shrinks []templateShrink
	for _, e := range sorted {
		shrinks = append(shrinks, templateShrink{
			Shrink:        shrinkStr(res[e.ix].Shrunk),
			ShrinkPercent: float64(e.n) / float64(len(res)) * 100,
		})
	}
	if len(shrinks) > maxShrinks {
		shrinks = shrinks[:maxShrinks]
	}

	return templateData{
		TestName:       report,
		LibraryName:    rapidName,
		LibraryVersion: rapidVersion,
		DistinctCount:  distinct,
		TotalCount:     len(res),
		Shrinks:        shrinks,
	}, nil
}

func run(report string, test string, count int) error {
	results, err := runTests(test, count)
	if err != nil {
		return fmt.Errorf("failed to run test %q: %w", test, err)
	}

	js, err := json.MarshalIndent(results, "", "  ")
	if err != nil {
		return fmt.Errorf("failed to serialize JSON: %w", err)
	}

	err = os.MkdirAll(reportsDir, reportsDirPerm)
	if err != nil {
		return fmt.Errorf("failed to create %q dir: %w", reportsDir, err)
	}

	err = os.WriteFile(filepath.Join(reportsDir, report+".json"), js, reportPerm)
	if err != nil {
		return fmt.Errorf("failed to write JSON report: %w", err)
	}

	td, err := analyze(report, results)
	if err != nil {
		return fmt.Errorf("failed to analyze results: %w", err)
	}

	md, err := os.OpenFile(filepath.Join(reportsDir, report+".md"), os.O_CREATE|os.O_TRUNC|os.O_RDWR, reportPerm)
	if err != nil {
		return fmt.Errorf("failed to create MarkDown report file: %w", err)
	}
	defer func() { _ = md.Close() }()

	b := bufio.NewWriter(md)
	err = reportTmpl.Execute(b, td)
	if err != nil {
		return fmt.Errorf("failed to execute MarkDown report file: %w", err)
	}

	err = b.Flush()
	if err != nil {
		return fmt.Errorf("failed to flush MarkDown report buffer: %w", err)
	}

	return nil
}

func main() {
	var (
		report = flag.String("report", "", "report name")
		test   = flag.String("test", "", "test name to run")
		count  = flag.Int("count", 100, "number of times to run each test")
	)
	flag.Parse()

	if *report == "" && *test == "" {
		toRun := []struct {
			report string
			test   string
		}{
			{"bound5", "TestBound5"},
			{"large_union_list", "TestLargeUnionList"},
			{"reverse", "TestReverse"},
			{"lengthlist", "TestLengthList"},
			{"difference_must_not_be_zero", "TestDifferenceNotZero"},
			{"difference_must_not_be_one", "TestDifferenceNotSmall"},
			{"difference_must_not_be_small", "TestDifferenceNotOne"},
			{"coupling", "TestCoupling"},
			{"deletion", "TestDeletion"},
			{"distinct", "TestDistinct"},
			{"nestedlists", "TestNestedLists"},
		}
		for _, r := range toRun {
			err := run(r.report, r.test, *count)
			if err != nil {
				log.Fatal(err)
			}
		}
	} else {
		err := run(*report, *test, *count)
		if err != nil {
			log.Fatal(err)
		}
	}
}
