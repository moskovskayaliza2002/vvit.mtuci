
import scala.util.{Try, Failure, Success}
object Adts extends App {

  // a) Дан List[Int], верните элемент с индексом n
  def getNth(list: List[Int],n: Int):Option[Int]={
     list match {
       case head :: tail => Some(list(n))
       case Nil   => None
       case null  => None
     }
  }
  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру 
  def testGetNth(list: List[Int], n: Int): Option[Int] = getNth(list,n)
  println(s"1. return the third number of list: ${testGetNth(List(1, 2, 3, 4, 5), 3)}")


  // b) Напишите функцию, увеличивающую число в два раза.
  def double(n: Option[Int]):Option[Int]={
    n match {
      case Some(a) => Some(2*a)
      case None => None
    }
  }
  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = double(n)
  println(s"2. return the 2*x: ${testDouble(Some(50))}")


  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  def isEven(n: Int):Either[String, Int]= {
    Either.cond(n % 2 == 0, n, "Нечетное число") match {
      case Left(s) => Left(s)
      case Right(i) => Right(i)
    }
  }

    // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
    def testIsEven(n: Int): Either[String, Int] = isEven(n)
    println(s"3. Does number 3 even? ${testIsEven(3)}")


    // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
    def safeDivide(a: Int, b: Int): Either[String, Int] = {
      Either.cond(b != 0, a / b, "Нельзя делить на ноль") match {
        case Left(s) => Left(s)
        case Right(i) => Right(i)
      }
    }

      // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
      def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a, b)
      println(s"4. Can i execute 14/0? ${testSafeDivide(14, 0)}")


      // e) Обработайте исключения функции с побочным эффектом вернув 0.
      def goodOldJava(impure: String => Int, str: String): Try[Int] = {
        Try(impure(str)) match {
          case Success(a) => Success(a)
          case Failure(error) => Failure(error)
        }
      }
      // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
      def testGoodOldJava(impure: String => Int, str: String): Try[Int] = goodOldJava(impure, str)
      def test(str:String):Int = str.toInt
      println(s"5. Can i change 8 to int? ${testGoodOldJava(test, "8")}")
      println(s"6. Can i change hello to int? ${testGoodOldJava(test, "hello")}")

}