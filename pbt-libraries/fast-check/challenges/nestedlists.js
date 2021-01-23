import fc from "fast-check";

export const nestedlistsProperty = fc.property(
  fc.array(fc.array(fc.constant(0))),
  (ls) => {
    return ls.map((l) => l.length).reduce((a, b) => a + b, 0) <= 10;
  }
);
