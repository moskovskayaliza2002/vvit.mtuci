
/** Напишите решение в виде функции.
 *
 * Синтаксис:
 *   val a: Int = ???
 *
 *   a match {
 *     case 0 => true
 *     case _ => false
 *   }
 */
object Patterns extends App {

  sealed trait Hand
  case object Rock extends Hand
  case object Paper extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat extends Food
  case object Vegetables extends Food
  case object Plants extends Food

  sealed trait Animal {

    val name: String
    val food: Food
  }
  case class Mammal(name: String, food: Food, weight: Int) extends Animal
  case class Fish(name: String, food: Food) extends Animal
  case class Bird(name: String, food: Food) extends Animal

  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */

  def IntCase(n: Int): String = n match{
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ => "what's that"
  }

  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = IntCase(value)
  println(s"1. Write what is '3': ${testIntToString(3)}")


  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */

  def isMaxOrMoritz(s: String): Boolean = s match{
    case "max" => true
    case "Мax" => true
    case "moritz" => true
    case "Moritz" => true
    case _ => false
  }
  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = isMaxOrMoritz(value)
  println(s"2. Moritz fine?: ${testIsMaxAndMoritz("Moritz")}")

  // c) Напишите функцию проверки является ли `value` четным
  def isEven(a: Int): Boolean = a % 2 == 0

  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = isEven(value)
  println(s"3. 22 is even?: ${testIsEven(22)}")

  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def RockScisPaper(a: Hand, b: Hand) = (a, b) match{
    case (Rock, Scissor) | (Paper, Rock) | (Scissor, Paper) => Win
    case (Paper, Paper) | (Scissor, Scissor) | (Rock, Rock) => Draw
    case _ => Lose
  }
  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand) = RockScisPaper(a, b)
  println(s"4. Will first guy win if he has Rock and opponent Scissor?: ${testWinsA(Rock, Scissor)}")

  // Примечание: используйте определение Animals
  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def MammalWeight(a: Animal): Int = a match{
    case a: Mammal => a.weight
    case _ => -1
  }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = MammalWeight(animal)
  println(s"5. What is weight of this animal Mammal(Floppa, Meat, 10)?: ${testExtractMammalWeight(Mammal("Floppa", Meat, 10))}")

  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.
  def updateFood(a: Animal): Animal = a match {
    case Fish(name, food) => Fish(name, Plants)
    case Bird(name, food) => Bird(name, Plants)
    case _ => a
  }

  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)
  println(s"6. Change food of this animal to plants Fish(Salmon, Meat): ${testUpdateFood(Fish("Salmon", Meat))}")

}