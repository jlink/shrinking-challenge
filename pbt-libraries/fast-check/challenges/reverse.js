import fc from "fast-check";

export const reverseProperty = fc.property(fc.array(fc.integer()), (ls) => {
  const rev = [...ls].reverse();
  expect(rev).toEqual(ls);
});
