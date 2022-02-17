package recfun



object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c == r) 1
    else r

  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    if (balance1(chars, 0) == 0) true
    else false
  }

  def balance1(chars2: List[Char], count: Int): Int = {
    chars2 match {
      case head :: tail =>
        if (head == '(') balance1(tail, count + 1)
        else if (head == ')') {
          if (count - 1 < 0) (count - 1)
          else {
            balance1(tail, count - 1)
          }
        }
        else balance1(tail, count)
      case Nil => count
    }
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }


}
