package euler

import util.Fraction

/**
  * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
  * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
  *
  * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
  * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
  */
object Prob033 extends App {

//  println(isCurious(Fraction(49,98)))
//  println(isCurious(Fraction(10,10)))
//  println(isCurious(Fraction(11,11)))

  val curiousFractions = for {
    n <- 10 to 99
    d <- n+1 to 99
    f = Fraction(n, d)
    if isCurious(f)
  } yield f

  println(curiousFractions)
  // Vector(Fraction(16,64), Fraction(19,95), Fraction(26,65), Fraction(49,98))

  val prod = curiousFractions.foldLeft(Fraction(1,1)) {
    case (acc, curr) => acc.multiply(curr)
  }
  println(prod)
  // -> 1/100

  private def isCurious(f: Fraction): Boolean = {
    val nominatorDigits = List(f.nominator / 10, f.nominator % 10)
    val denominatorDigits = List(f.denominator / 10, f.denominator % 10)
    val commonDigits = nominatorDigits.intersect(denominatorDigits)

    commonDigits.foldLeft(false) {
      case (acc, digit) => {
        if (digit != 0) {
          val n = nominatorDigits.filter(_ != digit) match  {
            case List(value) => value
            case Nil => digit
          }
          val d = denominatorDigits.filter(_ != digit)  match  {
            case List(value) => value
            case Nil => digit
          }
          if (d != 0) {
            Fraction(n,d).equals(f) || acc
          } else {
            acc
          }
        } else {
          acc
        }
      }
    }
  }
}
