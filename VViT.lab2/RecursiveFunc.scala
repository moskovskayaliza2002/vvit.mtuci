
import scala.annotation.tailrec
/** Реализуйте функции для решения следующих задач.
 * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подстверждения.
 * рекурсия будет хвостовой если:
 *   1. рекурсия реализуется в одном направлении
 *   2. вызов рекурсивной функции будет последней операцией перед возвратом
 */
object RecursiveFunc extends App{

  def length[A](as: List[A]): Int = {
    @tailrec
    def loop(rem: List[A], agg: Int): Int = rem match {
      case Cons(_, tail) => loop(tail, agg + 1)
      case Nil()         => agg
    }
    loop(as, 0)
  }

  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */
  def reverse[A](list: List[A]): List[A] = {
    @tailrec
    def loop(origin: List[A], reverse: List[A]): List[A] = origin match {
      case Cons(h, t) => loop(t, Cons(h, reverse))
      case Nil() => reverse
    }
    loop(list, Nil())
  }
  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testReverse[A](list: List[A]): List[A] = reverse(list)
  var test_a1: List[Int] = Cons(1901, Cons(13, Cons(12, Nil())))
  println("Cons(1901, Cons(13, Cons(12, Nil())))")
  println(s"1. Return reversed list : ${testReverse(test_a1)}")


  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def map[A, B](list: List[A])(f: A => B): List[B] = {
    @tailrec
    def loop(origin: List[A], changed: List[B]): List[B] = origin match {
      case Cons(h, t) => loop(t, Cons(f(h), changed))
      case Nil() => reverse(changed)
    }
    loop(list, Nil())
  }
  val toTen: (Int) => Int = _ * 10
  // используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)
  println(s"2. Return mapped result : ${testMap(test_a1, toTen)}")


  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def append[A](l: List[A], r: List[A]): List[A] = {
    @tailrec
    def loop(left: List[A], right: List[A] ): List[A] = left match {
      case Cons(h, t) => loop(t, Cons(h, right))
      case Nil() => right
    }
    loop(reverse(l), r)
  }

  // используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
  def testAppend[A](l: List[A], r: List[A]): List[A] = append(l,r)
  println(s"3. Append list to other : ${testAppend(test_a1, test_a1)}")

  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   * 
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в 
   *    списке. Поэтому вы создаете List[List[B]]. 
   */
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {
    @tailrec
    def loop(origin: List[A], result: List[B]): List[B] = origin match {
      case Cons(h, t) => loop(t, testAppend(f(h), result))
      case Nil() => reverse(result)
    }
    loop(list, Nil())
  }
  // используйте функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = flatMap(list)(f)
  println(s"4. Flatmap : ${testFlatMap(test_a1, (x: Int) => Cons(x * 10, Nil()))}")

  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */

  // Нельзя, т.к. будет нарушено правило функции с хвостовой рекурсией о реализации  в одном направлении.

}
