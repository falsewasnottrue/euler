
package prob001

/**
  * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
  * Find the sum of all the multiples of 3 or 5 below 1000.
  */
object Prob001 extends App {

  val limit = 1000
  val res = (1 until limit).filter(i => i % 3 == 0 || i % 5 == 0).sum
  // 233168
  println(res)

  val multiplesOf3 = Stream.from(3, 3)
  val multiplesOf5 = Stream.from(5, 5)

  val res2 = (multiplesOf3.takeWhile(_ < limit).toSet ++ multiplesOf5.takeWhile(_ < limit).toSet).sum
  println(res2)
  // 233168
}