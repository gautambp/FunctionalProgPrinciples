package funsets

object Main extends App {
  import FunSets._
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  println(contains(s1, 1))
  println(contains(s1, 2))
  val u = union(s1, s2)
  println(contains(u, 1))
  println(contains(u, 2))
  printSet(u)
  val m = map(u, (x: Int) => x+1)
  printSet(m)
}
