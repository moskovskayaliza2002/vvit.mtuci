
object Typeclasses extends App{

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.

  trait Reversable[T]{def reverse(value:T):T}

  // b) Реализуйте функцию Reverse для String.
  object Reversable {
    def reverse[T: Reversable](a: T): T = implicitly[Reversable[T]].reverse(a)
    implicit object ReversableString extends Reversable[String]{
      def reverse(str:String):String=str.reverse
    }
  }
  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(mystr: String): String = Reversable.reverse(mystr)
  println(s"1. Reverse: ${testReversableString("ayaksvocsom azil")}")
  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.

  trait Smash[T]{def smash(a: T, b: T): T}

  object Smash {
    def smash[T : Smash](a: T, b: T): T = implicitly[Smash[T]].smash(a,b)
    implicit object SmashInt extends Smash[Int]{
      def smash(numI1: Int,numI2: Int):Int= numI1 + numI2
    }
    implicit object SmashDouble extends Smash[Double]{
      def smash(numD1: Double,numD2: Double):Double= numD1 * numD2
    }
    implicit object SmashString extends Smash[String]{
      def smash(str1: String,str2: String):String = str1 + str2
    }
  }

  // d) Реализуйте  функции Smash для типа Int и Double.
  //    Используйте сложение для типа Int у умножение для типа Double.

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = Smash.smash(a, b)
  println(s"2. a = 5, b = 2, a + b? ${testSmashInt(5, 2)}")
  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashDouble(a: Double, b: Double): Double = Smash.smash(a, b)
  println(s"3. a = 5, b = 2, a * b? ${testSmashDouble(5, 2)}")


  // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра. 

  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashString(a: String, b: String): String = Smash.smash(a,b)
  println(s"4. a = 5, b = 2, a + b? ${testSmashString("5", "2")}")
}

