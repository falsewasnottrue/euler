package util

case class MultiSet[T](occurrences: Map[T, Int] = Map[T, Int]()) {

  def put(elem: T, count: Int = 1): MultiSet[T] = MultiSet(occurrences.updated(elem, get(elem)+count))

  def get(elem: T): Int = occurrences.getOrElse(elem, 0)

  def union[U >: T](other: MultiSet[U], combine: (Int, Int) => Int): MultiSet[T] =
    (occurrences.keys ++ other.occurrences.keys).foldLeft(MultiSet[T]()) {
      case (acc: MultiSet[T], key: T) => acc.put(key, combine(get(key), other.get(key)))
    }
}
