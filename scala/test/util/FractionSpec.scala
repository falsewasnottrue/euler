package util

import org.scalatest.{FlatSpec, Matchers}

class FractionSpec extends FlatSpec with Matchers {

  "Fraction" should "be able to give nominator and denominator" in {
      Fraction(1,2).nominator should be(1)
      Fraction(1,2).denominator should be(2)
  }

  it should "be able to reduce" in {
    Fraction(2,4).reduced.nominator should be(1)
    Fraction(2,4).reduced.denominator should be(2)
  }

  it should "test equality on reduced form" in {
    Fraction(3,6).equals(Fraction(5,10)) should be(true)
  }

  it should "multiply fractions" in {
    Fraction(1,2).multiply(Fraction(3,6)) should be(Fraction(1,4))
  }
}
