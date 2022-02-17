package Ejercicios

import scala.collection.mutable

case class Tag(tag: String)
case class Id(toInt: Int) {
  def next: Id = this.copy(toInt = toInt + 1)
}

object State extends Enumeration {
  type State = Value
  val Active, Completed = Value
}

import State._
case class Task(state: State, description: String, notes: Option[String], tags: List[Tag]) {
  def complete: Task = {
    val newState =
      state match {
        case State.Active => State.Completed
        case State.Completed => State.Completed
      }
    this.copy(state = newState)
  }
}

class IdGenerator(private var id: Id) {
  def nextId(): Id = {
    val currentId = id
    id = currentId.next
    currentId
  }
}
case class Tags(tags: List[Tag]) {
  def toList: List[Tag] = tags
}

case class Tasks(tasks: Iterable[(Id, Task)]) {
  def toList: List[(Id, Task)] =
    tasks.toList

  def toMap: Map[Id, Task] =
    tasks.toMap
}



object Coursera extends App {

  ///////////////////////////////////////////////////////////
  // meter en objeto InMemoryModel del proyecto todo
  ///////////////////////////////////////////////////////////
  def create(task: Task): Id = {
    val id = idGenerator.nextId()
    idStore += (id -> task)
    id
  }

  def read(id: Id): Option[Task] = {
    idStore.get(id)
  }

  def complete(id: Id): Option[Task] = {
    val tarea: Task = idStore(id)
    val newTarea = tarea.copy(State.Completed,tarea.description, tarea.notes, tarea.tags)
    update(id)(_ => newTarea)
  }

  def update(id: Id)(f: Task => Task): Option[Task] = {
    idStore.updateWith(id)(opt => opt.map(f))
  }

  // Obtiene una lista de todas las tareas, ordenadas por ID.
  def tasks: Tasks =
    Tasks(idStore)

  // Devuelve todas las etiquetas que están actualmente en uso.
  def tags: Tags = {
    Tags(idStore.flatMap(_._2.tags).toList.distinct)
  }

  // Devuelve todas las tareas etiquetadas con la etiqueta dada.
  def tasks(tag: Tag): Tasks = {
    Tasks(idStore.filter(_._2.tags.contains(tag)))
  }

  ///////////////////////////////////////////////////////////
  // hasta aqui
  ///////////////////////////////////////////////////////////

  val defaultTasks = List(
    Id(0) -> Task(State.Completed, "Complete Effective Scala Week 2", None, List(Tag("programming"), Tag("scala"))),
    Id(1) -> Task(State.Active, "Complete Effective Scala Week 3", Some("Finish the todo list exercise"), List(Tag("programming"), Tag("scala"), Tag("encapsulation"), Tag("sbt"))),
    Id(2) -> Task(State.Active, "Make a sandwich", Some("Cheese and salad or ham and tomato?"), List(Tag("food"), Tag("lunch"))),
  )

  val idGenerator = new IdGenerator(Id(3))

  private val idStore: mutable.LinkedHashMap[Id, Task] =
    mutable.LinkedHashMap.from(defaultTasks)

  val nuevaTarea: Task = Task(State.Active, "Tomar un cafe", Some("Azucar o Edulcorante?"), List(Tag("bebida"), Tag("almuerzo")))

  println(create(nuevaTarea))
  println(idStore)
  println(read(Id(2)))
  println(idStore(Id(2)))
  println(complete(Id(3)))
  println("imprime tasks")
  println(tasks)
  println("imprime tares con ese tag")
  val j: Tag = Tag("bebida")
  println (tasks(j))
  println("mostramos los distintos tags")
  println(tags)

/*
case class Tags(tags: List[Tag]) {
  def toList: List[Tag] = tags
}
  def tasks(tag: Tag): Tasks =
    Tasks(idStore)
 */

}
