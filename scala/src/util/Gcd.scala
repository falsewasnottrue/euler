package util

object Gcd {
  def of(a: Int, b: Int): Int = if (b == 0) a else of(b, a % b)
}
