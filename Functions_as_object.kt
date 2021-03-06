fun getRealGrade(x: Double) = x // 1.0
fun getGradeWithPenalty(x: Double) = x - 1

fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
    if (isCheater) {
        return ::getGradeWithPenalty
    }

    return ::getRealGrade
}

fun applyAndSum(a: Int, b: Int, transformation: (Int) -> Int): Int { // 2.0 Function references as function parameters
    return transformation(a) + transformation(b)
}

fun isNotDot(c: Char): Boolean = c != '.' // 3.0 Real-world usage
/*The previous example seems to be a bit synthetic. What about more realistic examples? Well, see for yourself.

The String type has the filter method to filter symbols. How does it know which symbols to remove from the string and which ones to leave in it? The answer is simple: this method takes a predicate as an argument and then uses it for internal computations. A predicate is a function that takes an argument and returns a Boolean result. So in the filter method, the predicate says if the symbol should be left and has the (Char) -> Boolean type.

Let's try to use this method. If we want to remove dots from a string, we declare this predicate:*/

fun main() {
    val wantedFunction = getScoringFunction(false) // 1.0 Functions returning other functions
    println(wantedFunction(10.0))

    fun same(x: Int) = x               // 2.0
    fun square(x: Int) = x * x
    fun triple(x: Int) = 3 * x

    applyAndSum(1, 2, ::same)    // returns 3 = 1 + 2
    applyAndSum(1, 2, ::square)  // returns 5 = 1 * 1 + 2 * 2
    applyAndSum(1, 2, ::triple)  // returns 9 = 3 * 1 + 3 * 2

    val originalText = "I don't know... what to say..." // 3.0
    val textWithoutDots = originalText.filter(::isNotDot)
}
