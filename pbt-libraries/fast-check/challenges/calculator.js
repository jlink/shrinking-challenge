import fc from "fast-check";

const { expression } = fc.letrec((tie) => ({
  expression: fc.oneof(
    { depthFactor: 0.5, withCrossShrink: true },
    fc.integer(),
    fc.tuple(fc.constant("+"), tie("expression"), tie("expression")),
    fc.tuple(fc.constant("/"), tie("expression"), tie("expression"))
  ),
}));
const div_subterms = (e) => {
  if (!Array.isArray(e)) {
    return true;
  }
  if (e[0] === "/" && e[2] === 0) {
    return false;
  }
  return div_subterms(e[1]) && div_subterms(e[2]);
};
const evaluate = (e) => {
  if (!Array.isArray(e)) {
    return e;
  }
  if (e[0] === "+") {
    return evaluate(e[1]) + evaluate(e[2]);
  }
  const a = evaluate(e[1]);
  const b = evaluate(e[2]);
  if (b === 0) {
    throw new Error("Division by 0");
  }
  return Math.floor(a / b);
};

export const calculatorProperty = fc.property(expression, (e) => {
  fc.pre(div_subterms(e));
  evaluate(e);
});
