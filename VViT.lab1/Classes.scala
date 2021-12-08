/* This task has no tests. It is an exercise for you to write different class structures.
 *
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 *
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 */
/*
* c) Добавьте следующие метод в Animals:
*      def eats(food: String): Boolean
*
*     который проверяет ест ли животное определенную пищу
*/
object Classes extends App {

  class Animal(val name: String, val species: String, val food: Food) {
    def eats(food: String): Boolean = food == this.food
  }
  println(s"1. Does cat eats Vegetables ? ${new Animal("cat", "mammal", Meat()).eats("Vegetables")}")

  /*b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
*      - cat, mammal, meat
*      - parrot, bird, vegetables
*      - goldfish, fish, plants
*
*    Синтаксис: object MyClass {
*              // статические поля и методы
*            }
*/
  object Animal {

    def Cat(): Animal = new Animal("cat", "mammal", Meat())
    def Parrot(): Animal = new Animal("parrot", "bird", Vegetables())
    def GoldFish(): Animal = new Animal("goldfish", "fish", Plants())

    /* e) Добавьте следующие функции в объект-компаньон Animal:
*      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
*      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
*/
    def knownAnimal(name: String): Boolean = name match {
      case "cat" => true
      case "parrot" => true
      case "goldfish" => true
      case _ => false
    }

    def apply(name: String): Option[Animal] = name match {
      case "cat" => Some(Cat())
      case "parrot" => Some(Parrot())
      case "goldfish" => Some(GoldFish())
      case _ => None()
    }
  }
  println(s"2. Cat is known animal? ${Animal.knownAnimal("cat")}")
  println(s"3. Can i apply cringe to animal? ${Animal.apply("cringe")}")

  /* d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
*    Вам все еще нужно поле `species`?
*/
  sealed trait AnimalT {
    val name: String
    val food: Food
  }

  case class Mammals(name: String, food: Food, weight: Int) extends AnimalT
  case class Birds(name: String, food: Food) extends AnimalT
  case class Fishes(name: String, food: Food) extends AnimalT

  /*
*
* f) Создайте трейт Food со следующими классами-образцами:
*      - Meat
*      - Vegetables
*      - Plants
*   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
*      def apply(food: String): Option[Food]
*/
  sealed trait Food

  case class Meat() extends Food
  case class Vegetables() extends Food
  case class Plants() extends Food

  object Food extends App {
    def apply(food: String): Option[Food] = {
      food match {
        case "Meat" => Some(Meat())
        case "Vegetables" => Some(Vegetables())
        case "Plants" => Some(Plants())
        case _ => None()
      }
    }
  }

  println(s"4. Can i apply Meat to food? ${Food.apply("Meat")}")

  sealed trait Option[A] {
    def isEmpty: Boolean
  }

  case class Some[A](a: A) extends Option[A] {
    val isEmpty = false
  }

  case class None[A]() extends Option[A] {
    val isEmpty = true
  }
}