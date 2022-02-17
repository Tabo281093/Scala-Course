object Recursion  extends App {




  // Multipicar numeros con recursion.
  def sum(xs: List[Int]): Int = {
    xs match {
      case head :: rest => head + sum(rest)
      case Nil => 0
    }

  }

  val list = List(1, 222, 3, 400, 5, 8, 9, 15)
  println(sum(list))


  def num(xs: List[Int], numMax: Int): Int = {
    xs match {
      case head :: rest =>
        if (head > numMax) num(rest, head)
        else num(rest, numMax)
      case Nil => numMax
    }
  }

  def max(xs: List[Int]): Int = {
    xs match {
      case head :: rest =>
        if (head > rest.head) head
        else max(rest)
      case Nil => 0
    }
  }

  println(num(list, 0))
  println(max(List(25, 35, 98)))


}

  object RecFun extends App {


    def balance1(chars2: List[Char], count: Int): Boolean = {
      chars2 match {
        case head :: tail =>
          if (head == '(')
            balance1(tail, count + 1)
          else if (head == ')')
            balance1(tail, count - 1)
          else balance1(tail, count)
        case Nil => false
      }
    }

    val listChar = "())(j"
    val j = listChar.toList



    def balance(chars: List[Char]): Boolean = {
      if (balance2(chars, 0) == 0) true
      else false
    }

    def balance2(chars2: List[Char], count: Int): Int = {
      chars2 match {
        case head :: tail =>
          if (head == '(')  balance2(tail, count + 1)
          else if(head == ')'){
            if (count - 1  < 0) (count - 1)
            else {
              balance2(tail, count - 1)}}
          else balance2(tail, count)
        case Nil => count
      }
    }
    println(balance(j))
  }

object Combinaciones extends App {

  def count(target: Int, coins: List[Int]): Int = {
    if (target == 0) 1
    else if (coins.isEmpty || target < 0) 0
    else count(target, coins.tail) + count(target - coins.head, coins)
  }


  println(count(300,List(500,5,50,100,20,200,10)))



}