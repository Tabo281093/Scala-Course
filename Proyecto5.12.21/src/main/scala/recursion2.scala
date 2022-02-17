import netscape.javascript.JSObject

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Success, Using}

object recursion2 extends App {
  val x = 4
  val t = List(1, 2)

  class User(name: String, password: String)

  def insertUser(login: String, hashPassword: String): User = ???

  val seq = Set(1, 2, 3, 4, 5, 6)
  val list = List(7, 8, 9, 10)
  val opt = Option(3)

  





  def toTuple[E]: E => (E, E) = e => (e, e)

  println(list.map(e => (e, e)))
  println(list.flatMap(e => List(e, e)))
  println(opt.map(e => (e, e)))
  println(opt.flatMap(e => Option(toTuple(e))))

  val either: Either[String, Int] = Right(2)
  val either2: Either[String, Int] = Left("lol")

  // 1- Either[String, Int](2,2) === Right(2,2)
  println(either.map(x => toTuple(x)))
  // 2- Either[String, Int]("lol") === Left("lol")
  println(either2.map(x => toTuple(x)))
  println(either.flatMap(x => Right(toTuple(x))))




  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext

  implicit val executor: ExecutionContext = scala.concurrent.ExecutionContext.global

  import scala.util.{Try, Success, Failure}


  class userId(userId: Int)

  def getUserId(id: userId): Future[userId] = ???





  val xr: Try[Int] = Try(5)
  val tr: Try[Int] = Try(throw new Exception("bomba jajjaj"))
  println(tr, xr)

  class Bomba extends Exception

  val futureSuccess: Future[Int] = Future(1)
  val futureFailure: Future[Int] = Future(throw new Bomba)

  println(futureSuccess)


  //--------------------------------------------------------------------------------------------------


  def muliplic(mult: Int): Future[Unit] = {
    Future(mult * mult)
  }

  def sum(num: Int): Future[Int] = ???

  println(muliplic(3))
}

 object Mp extends App {
    val sum = 5 + 5
    val password = List("esteesmipassword", "hola", "me fui")
    val change = password.toList
    val fold = change.foldLeft("")((a,b) => a + b + b)
   println(change)
   println(password.flatMap(x => "hola" + x ))

   import scala.concurrent.Future
   import scala.concurrent.ExecutionContext

   implicit val executor: ExecutionContext = scala.concurrent.ExecutionContext.global

   /*val fa = Future(println("A"))
   val fb = Future(println("B"))
   for{
     _ <- fa
     _ <- fb
   }
   yield ()*/
   val m = List(1,2,3,4,5,6,7,8,9)
   val x = (1 until 7).flatMap(i =>
              (1 until i).map(j => (i,j))).filter(pair => (pair._1 + pair._2) % 2 == 0)
   val f = List(4,5,6,7,8,9,4)
   val k = for {
     (x1,y) <- f.zip(m)
   } yield x1 + y

   println(x)
   println(k)
   println(f.zip(m))
   val g = "ABC"
   val g2 = "2323"
   val g3 = Map('A' -> '2')
   val g4 = List("hola", "hola", "- me fui")
   val g5 = "ACCCOOOPPP"
   val mesjText = Map('2' -> "ABC", '3' -> "DEF")
   val combination = List(('a', 2), ('b', 2))
   val mapaChar: Map[Char, Char] =
     for ((digt, str) <- mesjText; ltr <- str) yield ltr -> digt

   println(mapaChar)
   println(g.map(mapaChar))
   println(g.map(x => (x,g2)))
   println(g4.filter(text => text.forall(txt => txt.isLetter)))






   //def wordOccurrences(w: Word): Occurrences = ???

      /* val map1 = g5.groupBy(c => c.toLower)
   println(map1)
     val map2 = map1.map(x => (x._1,x._2.length))
   println(map2)
        (map2.toList: List[(Char, Int)]).sorted

------------------------------------------------------
   for{
      groupby <- w.groupBy(x => x.toLower)

      } yield groupby._1 -> groupby._2.length

    }.toList
--------------------------------------------------------
   def wordOccurrences(w: Word): Occurrences = {
    val map1 = w.toList.groupBy((element: Char) => element.toLower)
    val map2 = map1 map { case (k, v) => k -> (v.length) }
    (map2.toList: List[(Char, Int)]).sorted

   * Esta formula la escribio otro programador media redundante :D

       */
 }


object hackerRank extends App{

  val t = for{
    x <- (2 until 10)
    z <- (2 until x)
    if(x % z == 0)
  } yield println(x,z)



  /*val n =  2 // io.StdIn.readInt()
      (1 to n).foreach { i =>
        val k = 4 //io.StdIn.readInt()
        val list = (1 to k).map(x => io.StdIn.readLine.split("\\s+")(0)).toList
        if (list.distinct.size == list.size) println("YES")
        else println("NO")
      }*/
  //---------------------------------------------------------------------------------

  /*import scala.io.StdIn.{readInt, readLine}

    (1 to readInt).map(_ => rotateAll(readLine)).foreach(println)

  def rotateAll(s: String): String =
    (1 to s.length).scanLeft(s){ case (s, x) => rotate1(s) }.tail.mkString(" ")

  def rotate1(s: String): String =
    s.tail.foldRight(List(s.head))(_ :: _).mkString*/

//----------------------------------------------------------------------------------------------
  /* def removeDuplicates(xs: List[Char]): List[Char] =
      xs match {
      case Nil => xs
      case head :: tail => head :: removeDuplicates(
        for (
          x <- tail
          if x != head)
        yield x)
    }
println(removeDuplicates("hhoollaa".toList).mkString)


  def distinctOnSorted[V](seq: List[V]): List[V] = {
     seq.foldLeft(List[V]())((result, v) =>
      if (result.isEmpty || v != result.head) v :: result else result)
      .reverse
  }
  println(distinctOnSorted("hhoollaa".toList))*/

  /*val texto = io.StdIn.readLine()
  val j = texto.toList.distinct
  val t = j.mkString
  println(t)*/

//------------------------------------------------------------------------

  //val l = List(1,2,3,4,5)
 // val s = l.scanLeft(0)((x, i) => x + i ).foreach(println)

  /*def compareTriplets(a: Array[Int], b: Array[Int]): Unit = {
    // Write your code here
    val bob = List.empty
    val alice = List.empty
    //val a1 = a.zipWithIndex
    //val b1 = b.zipWithIndex
    val a2 = List(1, 2, 3).zip(List(1, 2, 3))

    (a, b)
    for {
      x <- a
      s <- b
    }


  */






}










  /*  def mycomb[T](n: Int, l: List[T]): List[List[T]] =
    n match {
      case 0 => List(List())
      case _ => for(el <- l;
                    sl <- mycomb(n-1, l dropWhile { _ != el }))
      yield el :: sl
    }

  //def comb[T](n: Int, l: List[T]): List[List[T]] = mycomb(n, l.removeDuplicates)

  println(mycomb(x, t))*/




