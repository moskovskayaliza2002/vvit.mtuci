/** Напишите отдельные функции, решающие поставленную задачу. 
 *
 * Синтаксис:
 *   // метод
 *   def myFunction(param0: Int, param1: String): Double = // тело
 *
 *   // значение
 *   val myFunction: (Int, String) => Double (param0, param1) => // тело
 */
object Functions extends App{

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def area(r: Double): Double = r * r * Math.PI
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = area(r)
  println(s"1. Area of circle where r = 2: ${testCircle(2)}")

  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def CArea(a: Double): Double => Double = (b: Double) => a * b
  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = CArea(a)(b)
  println(s"2.(car) Area of rectangle where a = 2, b = 3: ${testRectangleCurried(2, 3)}")

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def RectArea(a: Double, b: Double): Double = a * b
  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = RectArea(a, b)
  println(s"3.(not car) Area of rectangle where a = 2, b = 3: ${testRectangleCurried(2, 3)}")
}