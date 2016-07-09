package util

case class Polynomial(coefficients: List[Double]) {

  val degree = if (coefficients == Nil) 0 else coefficients.length - 1

  override val toString = if (coefficients == Nil) "0" else coefficients.zipWithIndex.
    map { case (value, pos) => (value, pos-degree) }.
    filter( _._1 != 0).
    map { case (value, deg) => s"$value * x^$deg" }.mkString("+")

  // ...
}
