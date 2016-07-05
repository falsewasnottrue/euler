package util

import org.scalatest.{FlatSpec, Matchers}

class MultiSetSpec extends FlatSpec with Matchers {

  "MultiSet" should "be initially empty" in {
    MultiSet[Int]().size shouldBe 0
  }

  it should "have size 1 if a single element is added" in {
    MultiSet[Int]().put(1).size shouldBe 1
  }

  it should "have size 1 if a single element is added twice" in {
    MultiSet[Int]().put(1, 2).size shouldBe 1
  }

  it should "retrieve the number of occurences for elements" in {
    MultiSet[Int]().get(1) shouldBe 0
    MultiSet[Int]().put(1).get(1) shouldBe 1
    MultiSet[Int]().put(1).put(1).get(1) shouldBe 2
    MultiSet[Int]().put(1).put(1,2).get(1) shouldBe 3
  }

  it should "allow to calculate the union of 2 multisets" in {
    MultiSet[Int]().union(MultiSet[Int](), Math.max).size shouldBe 0
    MultiSet[Int]().put(1).union(MultiSet[Int](), Math.max).size shouldBe 1
    MultiSet[Int]().put(1).union(MultiSet[Int]().put(1), Math.max).size shouldBe 1
    MultiSet[Int]().union(MultiSet[Int]().put(1), Math.max).size shouldBe 1

    MultiSet[Int]().put(1,2).union(MultiSet[Int](), Math.max).get(1) shouldBe 2
    MultiSet[Int]().put(1,2).union(MultiSet[Int]().put(1), Math.max).get(1) shouldBe 2
  }
}
