import fc from "fast-check";

export const lengthlistProperty = fc.property(
  fc.integer(1, 100).chain((n) => fc.genericTuple(Array(n).fill(fc.nat(1000)))),
  (ls) => {
    return ls.reduce((a, b) => Math.max(a, b), 0) < 900;
  }
);

// Alternative property:
// As we request for an explicit size in this test, genericTuple is better fit.
// array is designed for dynamic sized arrays with non-explicit length.

//export const lengthlistProperty = fc.property(
//  fc
//    .integer(1, 100)
//    .chain((n) => fc.array(fc.nat(1000), { minLength: n, maxLength: n })),
//  (ls) => {
//    return ls.reduce((a, b) => Math.max(a, b), 0) < 900;
//  }
//);
