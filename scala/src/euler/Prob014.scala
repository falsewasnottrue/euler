package euler

import util.Collatz

object Prob014 extends App {
  val N = 1000000
  val res = ((1 to N) map (i => (i, Collatz.seqLen(i)))).maxBy(_._2)

  println(res)
  // -> (837799,525)
}
