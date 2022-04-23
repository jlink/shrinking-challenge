package challenges.deletion

import com.sageserpent.americium.Trials
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class DeletionSpec extends AnyFlatSpec with Matchers {
  private val api = Trials.api


  // NOTE: make the `Trials` DSL work for us - rather than building lists of wildly varying integers
  // and hoping for a duplicate, encourage the generation of duplicates by building a set of candidate
  // elements and then making a list from just those elements. Simply throwing together lists directly
  // from, say `api.integers()` is extremely unlikely to create duplicates unless an artificial range
  // clamp is imposed, which would cause the lists to have clustered elements, thus losing generality.
  private val lists: Trials[List[Int]] = api.integers.sets.filter(_.nonEmpty).flatMap(api.choose(_).lists)


  private val cases: Trials[(List[Int], Int)] = lists
    .filter(_.nonEmpty)
    // As Scala allows direct pattern matching on tuples, we can supply both the list and the
    // removal index in one fell swoop, which lets us drive the generation of removal indices
    // based on the list size, rather than having to discard ill-formed test cases.
    .flatMap(list => api.integers(0, list.size - 1).map(list -> _))

  private val snoopOnShrinkage = () => {
    var failedCaseCounter = 0

    { caze: Any =>
      println(s"$failedCaseCounter - Shrinkage has found a failing case: $caze")
      failedCaseCounter += 1
      false
    }
  }

  "deletion done incorrectly" should "fail" in {
    def incorrectDeletion(list: List[Int], indexOfElementToRemoveFromList: Int): (Int, List[Int]) = {
      list.splitAt(indexOfElementToRemoveFromList) match {
        case (head, removed :: tail) => removed -> (head ++ tail)
      }
    }

    var caseCounter = 0

    cases.withLimits(casesLimit = 20, shrinkageStop = snoopOnShrinkage).supplyTo {
      case (list, indexOfElementToRemoveFromList) =>

        val (removedItem, remainder) = incorrectDeletion(list, indexOfElementToRemoveFromList)

        remainder should not contain removedItem

        caseCounter += 1
    }

    println(s"Examined $caseCounter cases")
  }

  "deletion done correctly" should "succeed" in {
    def correctDeletion(list: List[Int], indexOfElementToRemoveFromList: Int): (Int, List[Int]) = {
      list.splitAt(indexOfElementToRemoveFromList) match {
        case (head, removed :: tail) => removed -> (head ++ tail).filterNot(removed == _)
      }
    }

    var caseCounter = 0

    cases.withLimits(casesLimit = 20).supplyTo {
      case (list, indexOfElementToRemoveFromList) =>
        val (removedItem, remainder) = correctDeletion(list, indexOfElementToRemoveFromList)

        remainder should not contain removedItem

        caseCounter += 1
    }

    println(s"Examined $caseCounter cases")
  }
}
