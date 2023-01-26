package challenges.calculator

import CalculatorSpec.{
  checkDivisorsAreNonZeroIn,
  expressions,
  integersAreFractionalIfYouAreDesperateEnoughEvidence,
  wellManneredExpressions,
  wellManneredExpressionsWithoutZeroConstants
}
import cats.implicits._
import com.sageserpent.americium.java.CasesLimitStrategy
import com.sageserpent.americium.{Factory, Trials}
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.math.Fractional.Implicits.infixFractionalOps
import scala.util.Try

object CalculatorSpec {
  // This is intentionally weak...
  def checkDivisorsAreNonZeroIn[Value: Fractional](
      expression: Expression[Value]
  ): Boolean =
    expression match {
      case Division(_, Constant(value))
          if implicitly[Fractional[Value]].zero == value =>
        false // True, but what if the right hand subexpression *evaluates* to zero?
      case Division(left, right) =>
        checkDivisorsAreNonZeroIn(left) && checkDivisorsAreNonZeroIn(right)
      case Addition(left, right) =>
        checkDivisorsAreNonZeroIn(left) && checkDivisorsAreNonZeroIn(right)
      case Constant(_) => true
    }

  sealed abstract class Expression[Value: Fractional] {
    def evaluate(): Try[Value]
  }

  case class Constant[Value: Fractional](value: Value)
      extends Expression[Value] {
    override def evaluate(): Try[Value] = value.pure[Try]
  }

  case class Addition[Value: Fractional](
      left: Expression[Value],
      right: Expression[Value]
  ) extends Expression[Value] {
    // NOTE: applicative combination, so both operands are evaluated.
    override def evaluate(): Try[Value] =
      (left.evaluate() -> right.evaluate()).mapN(_ + _)
  }

  case class Division[Value: Fractional](
      left: Expression[Value],
      right: Expression[Value]
  ) extends Expression[Value] {
    // NOTE: monadic combination instead of applicative approach, so short-circuits when the right evaluates to zero ....
    override def evaluate(): Try[Value] = for {
      rightEvaluated <- right.evaluate()
      evidence = implicitly[Fractional[Value]]
      if evidence.zero != rightEvaluated
      leftEvaluated <- left.evaluate()
    } yield leftEvaluated / rightEvaluated
  }

  // NASTY HACK - but this does highlight that integer division is questionable in this example...
  implicit val integersAreFractionalIfYouAreDesperateEnoughEvidence
      : Fractional[Int] = new Fractional[Int] {
    def div(x: Int, y: Int): Int = x / y // NASTY HACK!
    def plus(x: Int, y: Int): Int = x + y
    def minus(x: Int, y: Int): Int = ???
    def times(x: Int, y: Int): Int = ???
    def negate(x: Int): Int = ???
    def fromInt(x: Int): Int = x
    def parseString(str: String): Option[Int] = ???
    def toInt(x: Int): Int = ???
    def toLong(x: Int): Long = ???
    def toFloat(x: Int): Float = ???
    def toDouble(x: Int): Double = ???
    override def signum(x: Int): Int = ???
    override def sign(x: Int): Int = ???
    override def compare(x: Int, y: Int): Int = ???
  }

  // Magic auto-derivation! NOTE: this will generate division expressions that evaluate to zero simply because of integer
  // arithmetic rounding; this gives the test an unfair advantage in detecting the underlying problem.
  val expressions: Trials[Expression[Int]] =
    implicitly[Factory[Expression[Int]]].trials

  // More magic auto-derivation - this time we have to supply a custom factory for `BigDecimal` to bootstrap the automatic derivation.
  val wellManneredExpressions: Trials[Expression[BigDecimal]] = {
    implicit val evidence: Factory[BigDecimal] =
      Factory.lift(Trials.api.integers(-1000, 1000).map(BigDecimal.apply))

    implicitly[Factory[Expression[BigDecimal]]].trials
  }

  // Still more magic auto-derivation - this time we avoid 'obvious' failing cases to make the test work even harder...
  val wellManneredExpressionsWithoutZeroConstants
      : Trials[Expression[BigDecimal]] = {
    implicit val evidence: Factory[BigDecimal] =
      Factory.lift(
        Trials.api.integers(-1000, 1000).filter(0 != _).map(BigDecimal.apply)
      )

    implicitly[Factory[Expression[BigDecimal]]].trials
  }
}

class CalculatorSpec extends AnyFlatSpec with Matchers with BeforeAndAfter {
  private var testCaseCount: Integer = 0

  private val snoopOnShrinkage = () => {
    var failedCaseCounter = 0

    { caze: Any =>
      println(
        s"$failedCaseCounter - Shrinkage has found a failing case: $caze after $testCaseCount trials including this one."
      )
      failedCaseCounter += 1
      false
    }
  }

  before { testCaseCount = 0 }

  "an expression" should "fail only if the right hand operand evaluates to zero" in expressions
    .withStrategy(
      _ => CasesLimitStrategy.timed(Duration.apply(5, TimeUnit.SECONDS)),
      shrinkageStop = snoopOnShrinkage
    )
    .supplyTo { expression =>
      testCaseCount += 1

      Trials.whenever(checkDivisorsAreNonZeroIn(expression)) {
        expression.evaluate().get
      }
    }

  it should "fail only if its well-mannered right hand operand evaluates to zero" in wellManneredExpressions
    .withStrategy(
      _ => CasesLimitStrategy.timed(Duration.apply(5, TimeUnit.SECONDS)),
      shrinkageStop = snoopOnShrinkage
    )
    .supplyTo { expression =>
      testCaseCount += 1

      Trials.whenever(checkDivisorsAreNonZeroIn(expression)) {
        expression.evaluate().get
      }
    }

  it should "fail only if its well-mannered right hand operand that is not a constant of zero evaluates to zero" in wellManneredExpressionsWithoutZeroConstants
    .withStrategy(
      _ => CasesLimitStrategy.timed(Duration.apply(5, TimeUnit.SECONDS)),
      shrinkageStop = snoopOnShrinkage
    )
    .supplyTo { expression =>
      testCaseCount += 1

      Trials.whenever(checkDivisorsAreNonZeroIn(expression)) {
        expression.evaluate().get
      }
    }
}
