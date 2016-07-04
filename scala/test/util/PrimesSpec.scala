package util

import org.scalatest.{FlatSpec, Matchers}
import util.Primes._

class PrimesSpec extends FlatSpec with Matchers {

  "primes" should "correctly test for primes" in {
    isPrime(1) shouldBe false
    isPrime(2) shouldBe true
    isPrime(3) shouldBe true
    isPrime(4) shouldBe false
    isPrime(5) shouldBe true
    isPrime(6) shouldBe false
    isPrime(7) shouldBe true
    isPrime(8) shouldBe false
    isPrime(9) shouldBe false
    isPrime(10) shouldBe false
  }

  it should "calculate next primes" in {
    nextPrime(2) shouldBe 3
    nextPrime(3) shouldBe 5
    nextPrime(4) shouldBe 5
    nextPrime(5) shouldBe 7
  }

  it should "calculate prime factors" in {
    primeFactors(2) shouldBe List(2)
    primeFactors(3) shouldBe List(3)
    primeFactors(4) shouldBe List(2,2)
    primeFactors(5) shouldBe List(5)
    primeFactors(6) shouldBe List(3,2)
    primeFactors(7) shouldBe List(7)
    primeFactors(8) shouldBe List(2,2,2)
    primeFactors(9) shouldBe List(3,3)
    primeFactors(10) shouldBe List(5,2)
  }
}
