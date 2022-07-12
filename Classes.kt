class Cat(val name: String) {
	fun sayMeow() {
		println("$name says: \"Meow\".")
	}

	inner class Bow(private val color: String) { //Внутренний класс, без inline - вложенный класс.
		fun putOnABow() {
			sayMeow()
			println("The bow is on!")
		}

		fun printColor() {
			println("The cat named $name has a $color bow.")
		}

	}
}


class Cell { //просто пример
	object BaseProperties {
		var width = 15
		var height = 10
	}

	var width = BaseProperties.width
	var height = BaseProperties.height
}


fun main() {

  val cat = Cat("Princess")
	val bow = cat.Bow("Gold")

	bow.putOnABow()
	bow.printColor()
	cat.sayMeow()
}
