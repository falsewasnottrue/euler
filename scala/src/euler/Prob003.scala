package euler

import util.Primes.primeFactors

/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143 ?
  */
object Prob003 extends App {

  println(primeFactors(600851475143L))
  // -> 6857
}
