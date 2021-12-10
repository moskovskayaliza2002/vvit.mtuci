
import scala.annotation.tailrec
object Sequence extends App{

  /* a) Найдите последний элемент Seq.*/
  def testLastElement[A](seq:Seq[A]):Option[A] = seq match {
    case init :+ last => Some(last)
    case Nil => None
  }
  var test1 = Seq(11, 12, 13, 14, 15)
  println("Sequence: (11, 12, 13, 14, 15)")
  println(s"1. The last element: ${testLastElement(test1)}")

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.*/
  def testZip2[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.zip(b)
  println(s"2. Compose sequence: ${testZip2(test1, test1)}")

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.*/
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = {
    @tailrec
    def loop(arg:Seq[A],res:Boolean):Boolean={
      arg match {
        case head::tail=>loop(tail, cond(head))
        case Nil=>res
      }
    }
    loop(seq, true)
  }
  def isEleven(num: Int):Boolean = num == 11
  println(s"3. Is every element = 11: ${testForAll(test1)(isEleven)}")

  /* d) Проверьте, является ли Seq палиндромом*/
  def testPalindrom[A](seq: Seq[A]): Boolean = {
    @tailrec
    def loop(arg:Seq[A],numb:Int):Int={
      arg.length match {
        case 0 => numb
        case 1 => numb
        case _ => if (arg.head == arg.last) loop(arg.tail.init,numb + 1) else numb
      }
    }
    return loop(seq,0) == seq.length/2
  }
  println(s"4. Is it palindrom: ${testPalindrom(Seq(1, 2, 5, 2, 1))}")

  /* e) Реализуйте flatMap используя foldLeft.*/
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = seq.foldLeft(Seq[B]())((x,y)=>x++:f(y))

  def func(x:Int):Seq[Int]=Seq(x, 10 * x)
  println(s"5. Realisation of flatmap: ${testFlatMap(Seq(1, 2, 5, 2, 1))(func)}")
}
