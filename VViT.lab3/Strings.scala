object Strings extends App{

  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы). */
  def testUppercase(str: String): String = str.toUpperCase()
  println(s"1. upper case: ${testUppercase("upper case")}")
  /* b) Вставьте следующие значения в строку:Hi my name is <name> and I am <age> years old.*/
  def testInterpolations(name: String, age: Int): String = s"Hi my name is $name and I am $age years old"
  println(s"2. introduction: ${testInterpolations("Eliza", 20)}")
  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   *         result is <a + b>*/
  def testComputation(a: Int, b: Int): String = s"Hi,\nnow follows a quite hard calculation. We try to add:\na := $a\nb := $b\nresult is ${a + b}"
  println(s"3. Computation: ${testComputation(1000, 7)}")
  /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.*/
  def testTakeTwo(str: String): String = {
    if(str.length==2) str else str.substring(0,2)
  }
  println(s"4. First two symbols of teamo: ${testTakeTwo("teamo")}")
}
