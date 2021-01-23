import fc from "fast-check";
import assert from "assert";

export const reverseProperty = fc.property(fc.array(fc.integer()), (ls) => {
  const rev = [...ls].reverse();
  assert.deepStrictEqual(rev, ls);
});
