package prob004

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Prob004 extends App {

  def isPalindrom(i: Int): Boolean = i.toString.reverse.toInt == i

  val res = (for {
    x <- 10 to 1000
    y <- 10 to 1000
    if isPalindrom(x*y)
  } yield (x, y, x*y)).maxBy(_._3)

  println(res)
  // -> (913,993,906609)
}
