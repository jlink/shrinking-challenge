# fast-chech

[fast-check](https://github.com/dubzzz/fast-check/blob/master/README.md) is a Property based testing framework for JavaScript/TypeScript.

## fast-check's Shrinking Approach

A deep-dive into the current implementation of fast-check, including its shrinking, is available on its official documnetation: https://github.com/dubzzz/fast-check/blob/master/documentation/HowItWorks.md

## Implemented Challenges

| Challenge                                           | Code                                                                                  | Report                                                                       |
| --------------------------------------------------- | ------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| [bound5](/challenges/bound5.md)                     | [bound5.js](/pbt-libraries/fast-check/challenges/bound5.js)                           | [bound5.md](/pbt-libraries/fast-check/reports/bound5.md)                     |
| [coupling](/challenges/coupling.md)                 | [coupling.js](/pbt-libraries/fast-check/challenges/coupling.js)                       | [coupling.md](/pbt-libraries/fast-check/reports/coupling.md)                 |
| [deletion](/challenges/deletion.md)                 | [deletion.js](/pbt-libraries/fast-check/challenges/deletion.js)                       | [deletion.md](/pbt-libraries/fast-check/reports/deletion.md)                 |
| [distinct](/challenges/distinct.md)                 | [distinct.js](/pbt-libraries/fast-check/challenges/distinct.js)                       | [distinct.md](/pbt-libraries/fast-check/reports/distinct.md)                 |
| [large union list](/challenges/large_union_list.md) | [large_union_list.js](/pbt-libraries/jqwik/fast-check/challenges/large_union_list.js) | [large_union_list.md](/pbt-libraries/fast-check/reports/large_union_list.md) |
| [reverse](/challenges/reverse.md)                   | [reverse.js](/pbt-libraries/fast-check/challenges/reverse.js)                         | [reverse.md](/pbt-libraries/fast-check/reports/reverse.md)                   |
| [nestedlists](/challenges/nestedlists.md)           | [nestedlists.js](/pbt-libraries/fast-check/challenges/nestedlists.js)                 | [nestedlists.md](/pbt-libraries/fast-check/reports/nestedlists.md)           |

## Running examples

You need node >= 10.

```bash
cd pbt-libraries/fast-check
npm run test
npm run report
```
