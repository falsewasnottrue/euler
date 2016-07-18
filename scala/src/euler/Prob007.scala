package euler

import util.Primes

/**
  * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
  * What is the 10 001st prime number?
  */
object Prob007 extends App {
  val pos = 10001

  def primes(n: Int): Stream[Int] = n #:: primes(Primes.nextPrime(n))

  val result = primes(2).drop(pos-1).head

  println(result)
  // -> 104743
}
