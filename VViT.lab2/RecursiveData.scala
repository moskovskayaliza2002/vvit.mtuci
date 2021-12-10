
sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]

/** Напишите свои решения в виде функций. */
object RecursiveData extends App{

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def IsListIntEmpty(list: List[Int]): Boolean = list match{
    case list: Nil[Int] => true
    case _ => false
  }
  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = IsListIntEmpty(list)
  var test_a1: List[Int] = Cons(1901, Cons(2021, Nil()))
  var test_a2: List[Int] = Nil()
  println(s"1. Is list Cons(1901, Cons(2021, Nil())) empty ? ${IsListIntEmpty(test_a1)}")
  println(s"2. Is list Nil() empty ? ${IsListIntEmpty(test_a2)}")

  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def listIntHead(list: List[Int]): Int = list match {
    case list: Cons[Int] => list.head
    case _ => -1
  }
  // используйте функцию из пункта (б) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = listIntHead(list)
  println(s"3. Get head of Cons(1901, Cons(2021, Nil())) empty ? ${testListIntHead(test_a1)}")
  println(s"4. Get head of Nil() ? ${testListIntHead(test_a2)}")

  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
  sealed trait NotNil[A]
  case class newCons[A](head: A, tail: NotNil[A]) extends NotNil[A]
  case class newNil[A](head: A) extends NotNil[A]

  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  sealed trait Tree[A]
  case class Node[A](leftNode: Tree[A], rightNode: Tree[A]) extends Tree[A]
  case class Leaf[A](leaf: A) extends Tree[A]
}
