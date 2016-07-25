package util

import org.scalatest.{FlatSpec, Matchers}

class GcdSpec extends FlatSpec with Matchers {

  "Gcd" should "calculate the gcd" in {
    Gcd.of(2,3) should be(1)
    Gcd.of(2,4) should be(2)
    Gcd.of(64,24) should be(8)
    Gcd.of(100,70) should be(10)
  }
}
