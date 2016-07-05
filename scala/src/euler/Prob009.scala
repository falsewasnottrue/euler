package euler

/**
  * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a2 + b2 = c2
  * For example, 32 + 42 = 9 + 16 = 25 = 52.
  * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  * Find the product abc.
  */
object Prob009 extends App {
  val result = for {
    a <- 1 until 1000 - 2
    b <- a+1 until 1000 - a
    c = 1000 - a - b
    if Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)
  } yield (a,b,c)

  println(result)
  // -> 200,375,425
}
