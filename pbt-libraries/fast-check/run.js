import fc from "fast-check";

import { existsSync, fstat, mkdirSync, writeFileSync } from "fs";
import { dirname, join } from "path";
import { fileURLToPath } from "url";
const __dirname = dirname(fileURLToPath(import.meta.url));
const reportDirectory = join(__dirname, "reports");

import { bound5Property } from "./challenges/bound5.js";
import { calculatorProperty } from "./challenges/calculator.js";
import { couplingProperty } from "./challenges/coupling.js";
import { deletionProperty } from "./challenges/deletion.js";
import { distinctProperty } from "./challenges/distinct.js";
import { largeUnionListProperty } from "./challenges/large_union_list.js";
import { lengthlistProperty } from "./challenges/lengthlist.js";
import { nestedlistsProperty } from "./challenges/nestedlists.js";
import { reverseProperty } from "./challenges/reverse.js";

const runsPerChallenge = 100;
const maxRunsPerTry = 1000;

function countShrinks(executionSummary) {
  let count = 0;
  let shrinks = executionSummary[executionSummary.length - 1].children;
  while (shrinks.length !== 0) {
    count += shrinks.length;
    shrinks = shrinks[shrinks.length - 1].children;
  }
  return count;
}
function runChallenge(challengeName, variableNames, property) {
  const summary = [];

  // Execute the challenge {challengeName} by running {property} {runsPerChallenge} times
  for (let runId = 0; runId !== runsPerChallenge; ++runId) {
    // Execute the property
    let numExecutions = 0;
    const out = fc.check(
      property.beforeEach(() => ++numExecutions),
      { numRuns: maxRunsPerTry, verbose: 2 }
    );

    if (!out.failed) {
      continue;
    }

    // numExecutions is the total number of runs started by fast-check
    // out.numRuns: Number of runs up to the first failure (including the failure run)
    // out.numSkips: Number of skipped entries due to failed pre-condition (only includes run started before the first failure)
    // out.numShrinks: Depth of the shrinking tree, not its size
    const evaluations = numExecutions - out.numRuns - out.numSkips;
    const evaluationsRecomputed = countShrinks(out.executionSummary);
    if (evaluations !== evaluationsRecomputed) {
      // As fast-check does not provide this count by default,
      // we make sure we get it right by computing it using two different methods.
      throw new Error(
        `Error during the computation of the number of failures. ` +
          `Counts mismatch (${evaluations} vs ${evaluationsRecomputed})`
      );
    }
    if (out.counterexample.length !== variableNames.length) {
      throw new Error(
        `Bad configuration for ${challengeName}, please check variableNames`
      );
    }
    const runReport = {
      evaluations: evaluations,
      seed: String(out.seed),
      shrunk: Object.fromEntries(
        variableNames.map((name, index) => [
          name,
          fc.stringify(out.counterexample[index]),
        ])
      ),
    };
    summary.push(runReport);
  }

  // Store the results
  if (!existsSync(reportDirectory)) {
    mkdirSync(reportDirectory);
  }
  writeFileSync(
    join(reportDirectory, `${challengeName}.json`),
    JSON.stringify(summary, undefined, 2)
  );
}

runChallenge("bound5", ["p"], bound5Property);
runChallenge("calculator", ["ls"], calculatorProperty);
runChallenge("coupling", ["ls"], couplingProperty);
runChallenge("deletion", ["ls", "i"], deletionProperty);
runChallenge("distinct", ["ls"], distinctProperty);
runChallenge("large_union_list", ["ls"], largeUnionListProperty);
runChallenge("lengthlist", ["ls"], lengthlistProperty);
runChallenge("nestedlists", ["ls"], nestedlistsProperty);
runChallenge("reverse", ["ls"], reverseProperty);
