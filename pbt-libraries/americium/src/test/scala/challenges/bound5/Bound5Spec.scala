package challenges.bound5

import cats.implicits.catsSyntaxTuple5Semigroupal
import challenges.bound5.Bound5Spec.{limit, quintuples}
import com.sageserpent.americium.Trials
import com.sageserpent.americium.java.CasesLimitStrategy
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration

object Bound5Spec {
  private val api = Trials.api

  private val limit: Short = 256

  private val listsOfShortsWithLimitedSums = api
    .integers(Short.MinValue, Short.MaxValue)
    .map(_.toShort)
    .lists
    .filter(limit > _.sum)

  private val quintuples =
    (
      listsOfShortsWithLimitedSums,
      listsOfShortsWithLimitedSums,
      listsOfShortsWithLimitedSums,
      listsOfShortsWithLimitedSums,
      listsOfShortsWithLimitedSums
    ) mapN Tuple5.apply
}

class Bound5Spec extends AnyFlatSpec with Matchers with BeforeAndAfter {
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

  after { println(s"Examined $testCaseCount cases in total.") }

  "the sum" should "be nor more than five times the limit on the individual sums" in {
    quintuples
      .withStrategy(
        caseSupplyCycle =>
          CasesLimitStrategy.timed(
            FiniteDuration(
              1 + caseSupplyCycle.numberOfPreviousShrinkages(),
              TimeUnit.SECONDS
            )
          ),
        shrinkageStop = snoopOnShrinkage
      )
      .supplyTo { quintuple =>
        testCaseCount += 1

        // Why does the original problem statement in Haskell insist on using a quintuple when it's much easier to use a sequence abstraction? Oh well...
        val sum: Short = quintuple.productIterator
          .asInstanceOf[Iterator[List[Short]]]
          .flatten
          .sum

        sum.toInt should be <= 5 * limit // The Scalatest DSL isn't looking so clever here.
      }
  }
}
