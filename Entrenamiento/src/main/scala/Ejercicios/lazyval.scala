package Ejercicios

object lazyval  extends  App {

  lazy val x = {
    println  ("hola")
    12
  }
  println(x)
  println(x)
}
