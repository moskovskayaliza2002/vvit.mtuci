object Maps extends App{

  case class User(name: String, age: Int)

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`*/
  def testGroupUsers(users: Seq[User]): Map[String, Int] = {
    def averageAge(num:Seq[Int]) = num.sum / num.length

    users.groupBy(_.name).map{
      myKey => (myKey._1, averageAge(myKey._2.map(_.age)))
    }
  }
  println(s"1. return the averageAge: ${testGroupUsers(Seq(User("Lisa",20),User("Ksenia",21),User("Alex",35),User("Lisa",68),User("Galina",80)))}")

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?*/
  def testNumberFrodos(map: Map[String, User]): Int = {
    map.count(x => x._2.name == "Adam")
  }
  println(s"2. return the number of Adams: ${testNumberFrodos(Map("first"->User("Adam",7),"second"->User("Eliza",21),"third"->User("Adam",30)))}")

  /* c) Удалите всех пользователей возраст которых менее 35 лет.*/
  def testUnderaged(map: Map[String, User]): Map[String, User] = {
      map.filter(x=>x._2.age>35)
  }
  println(s"3. remove zoomers: ${testUnderaged(Map("first"->User("Adam",7),"second"->User("Eliza",21),"third"->User("Adam",30), "fourth"->User("Winny", 55)))}")
}
