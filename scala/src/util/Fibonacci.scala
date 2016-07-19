package util

object Fibonacci {

  private def nextFib(curr: (BigInt, BigInt, BigInt)): (BigInt, BigInt, BigInt) = (curr._2, curr._3, curr._2 + curr._3)
  private def fibonacci(curr: (BigInt, BigInt, BigInt)): Stream[BigInt] = curr._2 #:: fibonacci(nextFib(curr))

  def stream: Stream[BigInt] = fibonacci((1,1,1))

}
