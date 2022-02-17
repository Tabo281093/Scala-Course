package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  printSet(union(singletonSet(15), singletonSet(25)))
  val a = Set(1,2,3,4,5)
  val b = Set(4,5,6,7,8)
  val c = Set(100, 200, 500, 600)
  printSet(union(a,b))
  printSet(intersect(a,b))
  printSet(diff(a,b))
  printSet(filter(a, x => x > 2))
  println(forall(c,  x => x > 1))
  printSet(map(a, x => x * 5))

}
