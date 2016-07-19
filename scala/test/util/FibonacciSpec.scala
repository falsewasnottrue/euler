package util

import org.scalatest.{FlatSpec, Matchers}

class FibonacciSpec extends FlatSpec with Matchers {

  "fibonnacis" should "return a stream of fibonacci numbers" in {
    Fibonacci.stream.take(10).toList shouldBe List(1,1,2,3,5,8,13,21,34,55)
  }
}
