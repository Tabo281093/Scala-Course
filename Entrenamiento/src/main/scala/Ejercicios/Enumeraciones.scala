package Ejercicios

object Enumeraciones extends App {

  // Define a new enumeration with a type alias and work with the full set of enumerated values
  object DiasSemana extends Enumeration {
    type DiasSemana = Value
    val Lunes, Martes, Mieercoles, Jueves, Viernes, Sabado, Domingo = Value
  }

  import DiasSemana._
  def isDiaLaborable(dia: DiasSemana) = ! (dia == Sabado || dia == Domingo)

  DiasSemana.values filter isDiaLaborable foreach println
  // output:
  // Lunes
  // Martes
  // Miercoles
  // Jueves
  // Viernes



  object EstadoTarea extends Enumeration {
    type Estado = Value
    val ParaHacer, EnCurso, Bloqueada, Terminada = Value
  }
  import EstadoTarea._
  val estadoTarea: Estado = EstadoTarea.EnCurso
  println(estadoTarea)
  // output:
  // EnCurso


}