package euler

import util.Primes

/**
  * Euler discovered the remarkable quadratic formula:
 **
 n² + n + 41
 **
 It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 **
 The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.
 **
 Considering quadratics of the form:
 **
 n² + an + b, where |a| < 1000 and |b| < 1000
 **
 where |n| is the modulus/absolute value of n
*e.g. |11| = 11 and |−4| = 4
*Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 *
 */
object Prob027 extends App {

  def poly(a: Int,b: Int): Int => Int = n => n*n + a*n + b

  def from(n: Int): Stream[Int] = n #:: from(n + 1)
  val nats = from(0)

  def primeLength(p: Int => Int): Int = nats.takeWhile(n => Primes.isPrime(p(n))).length

  val result =  (for {
    a <- -1000 to 1000
    b <- -1000 to 1000
    p = poly(a,b)
    l = primeLength(p)
  } yield (a,b,l)).maxBy(_._3)

  println(result)
  println(result._1 * result._2)

  // (-61,971,71) -59231
//  println(primeLength(poly(1, 41)))
//  println(primeLength(poly(-79, 1601)))
}
