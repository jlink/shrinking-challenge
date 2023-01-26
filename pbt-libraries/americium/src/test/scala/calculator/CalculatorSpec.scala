package calculator

import calculator.CalculatorSpec.{
  checkDivisorsAreNonZeroIn,
  snoopOnShrinkage,
  trees
}
import cats.implicits._
import com.sageserpent.americium.java.CasesLimitStrategy
import com.sageserpent.americium.{Factory, Trials}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.util.Try

object CalculatorSpec {
  // This is intentionally weak...
  def checkDivisorsAreNonZeroIn(expression: Expression): Boolean =
    expression match {
      case Division(_, Constant(0)) =>
        false // True, but what if the right hand subexpression *evaluates* to zero?
      case Division(left, right) =>
        checkDivisorsAreNonZeroIn(left) && checkDivisorsAreNonZeroIn(right)
      case Addition(left, right) =>
        checkDivisorsAreNonZeroIn(left) && checkDivisorsAreNonZeroIn(right)
      case Constant(_) => true
    }

  sealed trait Expression {
    def evaluate(): Try[Int]
  }

  case class Constant(value: Int) extends Expression {
    override def evaluate(): Try[Int] = value.pure[Try]
  }

  case class Addition(left: Expression, right: Expression) extends Expression {
    // NOTE: applicative combination, so both operands are evaluated.
    override def evaluate(): Try[Int] =
      (left.evaluate() -> right.evaluate()).mapN(_ + _)
  }

  case class Division(left: Expression, right: Expression) extends Expression {
    // NOTE: monadic combination instead of applicative approach, so short-circuits when the right evaluates to zero ....
    override def evaluate(): Try[Int] = for {
      rightEvaluated <- right.evaluate() if 0 != rightEvaluated
      leftEvaluated <- left.evaluate()
    } yield leftEvaluated / rightEvaluated
  }

  // Magic auto-derivation! NOTE: this will generate division expressions that evaluate to zero simply because of integer
  // arithmetic rounding; this gives the test an unfair advantage in detecting the underlying problem.
  val trees: Trials[Expression] = implicitly[Factory[Expression]].trials

  private val snoopOnShrinkage = () => {
    var failedCaseCounter = 0

    { caze: Any =>
      println(s"$failedCaseCounter - Shrinkage has found a failing case: $caze")
      failedCaseCounter += 1
      false
    }
  }
}

class CalculatorSpec extends AnyFlatSpec with Matchers {
  "an expression" should "fail only if the right hand operand evaluates to zero" in trees
    .withStrategy(
      _ => CasesLimitStrategy.timed(Duration.apply(5, TimeUnit.SECONDS)),
      shrinkageStop = snoopOnShrinkage
    )
    .supplyTo { tree =>
      Trials.whenever(checkDivisorsAreNonZeroIn(tree)) {
        println(tree.evaluate().get)
      }
    }
}
