package prob005

import util.MultiSet
import util.Primes.primeFactors

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Prob005 extends App {

  val N = 20

  val result = (1 until N).
    map(primeFactors(_)).
    map(_.foldLeft(MultiSet[Int]()) {
      case (acc, curr) => acc.put(curr)
    }).
    foldLeft(MultiSet[Int]()) {
      case (acc, curr) => acc.union(curr, (a,b) => Math.max(a,b))
    }.occurrences.
    foldLeft(1) {
      case (acc, curr) => acc * Math.pow(curr._1, curr._2).toInt
    }

  println(result)
  // -> 232792560
}
