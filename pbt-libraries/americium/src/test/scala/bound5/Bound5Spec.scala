package bound5

import cats.implicits.catsSyntaxTuple5Semigroupal
import com.sageserpent.americium.Trials
import com.sageserpent.americium.java.CasesLimitStrategy
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration


class Bound5Spec extends AnyFlatSpec with Matchers {
  private val api = Trials.api

  private val limit: Short = 256

  private val listsOfShortsWithLimitedSums = api.integers(Short.MinValue, Short.MaxValue).map(_.toShort).lists.filter(limit > _.sum)

  private val quintuples =
    (listsOfShortsWithLimitedSums, listsOfShortsWithLimitedSums, listsOfShortsWithLimitedSums,
      listsOfShortsWithLimitedSums, listsOfShortsWithLimitedSums) mapN Tuple5.apply

  private val snoopOnShrinkage = () => {
    var failedCaseCounter = 0

    { caze: Any =>
      println(s"$failedCaseCounter - Shrinkage has found a failing case: $caze")
      failedCaseCounter += 1
      false
    }
  }

  "the sum" should "be nor more than five times the limit on the individual sums" in {
    quintuples.withStrategy(caseSupplyCycle => CasesLimitStrategy.timed(FiniteDuration(1 + caseSupplyCycle.numberOfPreviousShrinkages(), TimeUnit.SECONDS)), shrinkageStop = snoopOnShrinkage).supplyTo { quintuple =>
      // Why does the original problem statement in Haskell insist on using a quintuple when it's much easier to use a sequence abstraction? Oh well...
      val sum: Short = quintuple.productIterator.asInstanceOf[Iterator[List[Short]]].flatten.sum

      sum.toInt should be <= 5 * limit // The Scalatest DSL isn't looking so clever here.
    }
  }
}
