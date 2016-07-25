package util

case class Fraction(nominator: Int, denominator: Int) {



  def reduced(): Fraction = {
    val d = Gcd.of(nominator, denominator)
    Fraction(nominator / d, denominator / d)
  }

  override def equals(obj: Any): Boolean = {
    if (!(obj.isInstanceOf[Fraction])) {
      false
    } else {
      val t1 = this.reduced()
      val t2 = obj.asInstanceOf[Fraction].reduced()

      t1.nominator == t2.nominator && t1.denominator == t2.denominator
    }
  }

  def isCurious(): Boolean = {
    false
  }
}
