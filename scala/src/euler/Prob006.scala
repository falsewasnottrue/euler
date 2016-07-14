package euler

/**
  * The sum of the squares of the first ten natural numbers is,
  * 12 + 22 + ... + 102 = 385
  *
  * The square of the sum of the first ten natural numbers is,
  * (1 + 2 + ... + 10)2 = 552 = 3025
  *
  * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
  * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
  */
object Prob006 extends App {
  val N = 100

  val sumOfSquares = (1 to N).map(i => i*i).sum
  val squareOfSums = { val i = (1 to N).sum; i*i }

  println(squareOfSums - sumOfSquares)
  // -> 25164150
}
