import fc from "fast-check";

export const distinctProperty = fc.property(fc.array(fc.integer()), (ls) => {
  return new Set(ls).size < 3;
});
