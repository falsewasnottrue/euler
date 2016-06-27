package prob003

/**
  * The prime factors of 13195 are 5, 7, 13 and 29.
  *
  * What is the largest prime factor of the number 600851475143 ?
  */
object Prob003 extends App {

  println(primeFactors(600851475143L))

  def isPrime(n: Int): Boolean =
    (2 to Math.sqrt(n).toInt).forall(n % _ != 0)

  def nextPrime(n: Int): Int = if (isPrime(n+1)) n+1 else nextPrime(n+1)

  def primeFactors(n: Long): List[Int] = {
    def primeFactorsAcc(n: Long, currPrime: Int, acc: List[Int]): List[Int] = if (n==1) {
      acc
    } else {
      if (n % currPrime == 0) {
        primeFactorsAcc(n / currPrime, currPrime, currPrime :: acc)
      } else {
        primeFactorsAcc(n, nextPrime(currPrime), acc)
      }
    }

    primeFactorsAcc(n, 2, Nil)
    // -> 6857
  }
}
