import fc from "fast-check";
import assert from "assert";

export const couplingProperty = fc.property(fc.array(fc.nat(10)), (ls) => {
  fc.pre(ls.every((v) => v < ls.length));
  for (let i = 0; i !== ls.length; ++i) {
    const j = ls[i];
    if (i !== j) {
      assert.notStrictEqual(ls[j], i);
    }
  }
});
