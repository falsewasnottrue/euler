package util

object Primes {
  def isPrime(n: Int): Boolean = if (n<2) false else
    (2 to Math.sqrt(n).toInt).forall(n % _ != 0)

  def nextPrime(n: Int): Int = if (isPrime(n+1)) n+1 else nextPrime(n+1)

  def primeFactors(n: Long): Seq[Int] = {
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
  }
}
