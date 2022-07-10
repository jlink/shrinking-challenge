#!/usr/bin/env bash

set -euo pipefail

# Prerequisites: `elm` and `elm-esm`. As they're in the `package.json` dependencies, we'll assume they're on PATH. If you run this script via `yarn start` (after having previously installed them via `yarn`), they will be.

export ELM_HOME="./elm-home"

# download all the libs

elm make src/Report.elm --output=/dev/null

# patch elm-explorations/test lib to use the current master (unreleased 2.0.0 that reimplements shrinking)

ELM_TEST_REVISION="490b1bfa7fc99456d19811042fd2593ff5132685"
ELM_TEST_ZIP="elm-test-${ELM_TEST_REVISION}.zip"
ELM_TEST_DIR="test-${ELM_TEST_REVISION}"
ELM_TEST_URL="https://codeload.github.com/elm-explorations/test/zip/${ELM_TEST_REVISION}"
curl -s "${ELM_TEST_URL}" --output "${ELM_TEST_ZIP}"
mkdir -p "${ELM_TEST_DIR}"
unzip -q -o "${ELM_TEST_ZIP}" -d .
cp -r "${ELM_TEST_DIR}"/{src,elm.json,LICENSE,README.md} "${ELM_HOME}"/0.19.1/packages/elm-explorations/test/1.2.2/
rm -rf "${ELM_TEST_DIR}"
rm "${ELM_TEST_ZIP}"

# patch elm-explorations/test lib to make the shrinker also give us a number of evaluations of the test function

patch -s --directory="${ELM_HOME}/0.19.1/packages/elm-explorations/test/1.2.2" -p1 <./patches/0001-Report-test-evaluations-for-shrinking-challenges.patch

# compile for real

rm -rf elm-stuff
rm elm-home/0.19.1/packages/elm-explorations/test/1.2.2/artifacts.dat
elm-esm make src/Main.elm --output=elm.js

# run!

node index.js
