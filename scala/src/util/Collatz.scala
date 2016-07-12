package util

object Collatz {

  private val memo = new scala.collection.mutable.HashMap[BigInt, Seq[BigInt]]()

  def seq(n: Int): Seq[BigInt] = {
    def seqAcc(acc: Seq[BigInt], current: BigInt): Seq[BigInt] =
      if (memo.get(current).isDefined)
        acc ++ memo.get(current).get
      else if (current == BigInt(1))
        acc :+ current
      else if (current % 2 == 0)
        seqAcc(acc :+ current, current / 2)
      else
        seqAcc(acc :+ current, 3*current + 1)


    val res = seqAcc(Nil, BigInt(n))
    memo.put(n, res)
    if (n % 1000 == 0) {
      println(n + "-> " + res)
    }

    res
  }

  private val memoLen = new scala.collection.mutable.HashMap[BigInt, Int]()

  def seqLen(n: BigInt): Int = {
    if (n % 1000 == 0) {
      println(n)
    }
    if (memoLen.get(n).isDefined) {
      memoLen.get(n).get
    } else if (n == 1) {
      1
    } else if (n % 2 == 0) {
      val res = seqLen(n/2)
      memoLen.put(n, res+1)
      res + 1
    } else {
      val res = seqLen(3*n+1)
      memoLen.put(n, res+1)
      res + 1
    }
  }
}
