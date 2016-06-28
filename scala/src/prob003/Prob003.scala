package prob003

import Primes._

/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143 ?
  */
object Prob003 extends App {

  println(primeFactors(600851475143L))
  // -> 6857
}
