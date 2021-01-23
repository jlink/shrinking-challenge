import fc from "fast-check";

export const deletionProperty = fc.property(
  fc.array(fc.integer()),
  fc.nat(10),
  (ls, i) => {
    fc.pre(i < ls.length);
    const x = ls[i];
    const copyWithoutX = [...ls.slice(0, i), ...ls.slice(i + 1)];
    return copyWithoutX.indexOf(x) === -1;
  }
);
