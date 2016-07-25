package util

import org.scalatest.{FlatSpec, Matchers}

class GcdSpec extends FlatSpec with Matchers {

  "Gcd" should "calculate the gcd" in {
    Gcd.of(2,3) should be(1)
  }
}
