fun main() {
    val lambda: (Long, Long) -> Long = { left: Long, right: Long ->
        var eq = 1L
        if (left == right) {
            right
        } else {
            for (i in left..right) {
                eq *= i
            }
            eq
        }
    }

    println(lambda(1, 5))
    
    //*****************************************************************************************************************************************************************
        
    fun isNotDot(c: Char): Boolean = c != '.'
    
    val originalText = "I don't know... what to say..."
    val textWithoutDots = originalText.filter(::isNotDot)
    
    val originalText = "I don't know... what to say..."
    val textWithoutDots = originalText.filter({ c: Char -> c != '.' }) //lambda
    
    //It works! First of all, Kotlin infers types of many objects, and here specifying the c type isn't necessary:

    /*originalText.filter({ c -> c != '.' })
    Second, there are situations when the lambda is passed as the last argument. This is the case. Kotlin provides a way to eliminate these bracket sequences ({ }), allowing to write the lambda outside the parentheses:
    originalText.filter() { c -> c != '.' }
    If the parentheses are left empty after this operation, you can remove them:
    originalText.filter { c -> c != '.' }
    Finally, when there is a single parameter in a lambda, there is an opportunity to skip it. The parameter is available under the it name. The final version of the code that removes dots is this:*/
       
    val originalText = "I don't know... what to say..."
    val textWithoutDots = originalText.filter { it != '.' }
    
    //Complex lambda
    val textWithoutSmallDigits = originalText.filter {
        val isNotDigit = !it.isDigit()
        val stringRepresentation = it.toString()

        isNotDigit || stringRepresentation.toInt() >= 5
    }

    //Lambda can contain earlier returns
    
    val textWithoutSmallDigits = originalText.filter {
        if (!it.isDigit()) {
            return@filter true
        }

        it.toString().toInt() >= 5
    }
}
