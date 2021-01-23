import fc from "fast-check";

export const largeUnionListProperty = fc.property(
  fc.array(fc.array(fc.integer())),
  (ls) => {
    return new Set(ls.flat()).size < 5;
  }
);
