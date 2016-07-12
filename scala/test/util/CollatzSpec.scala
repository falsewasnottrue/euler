package util

import org.scalatest.{FlatSpec, Matchers}

class CollatzSpec extends FlatSpec with Matchers {

  "Collatz" should "calculate sequences" in {
    Collatz.seq(13) shouldBe Seq(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)

    Collatz.seq(1) shouldBe Seq(1)
  }

  it should "calculate the lenght" in {
    Collatz.seqLen(1) shouldBe 1
    Collatz.seqLen(13) shouldBe 10
  }
}
