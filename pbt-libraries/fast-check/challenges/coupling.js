import fc from "fast-check";

export const couplingProperty = fc.property(fc.array(fc.nat(10)), (ls) => {
  fc.pre(ls.every((v) => v < ls.length));
  for (let i = 0; i !== ls.length; ++i) {
    const j = ls[i];
    if (i !== j) {
      expect(ls[j]).not.toBe(i);
    }
  }
});
