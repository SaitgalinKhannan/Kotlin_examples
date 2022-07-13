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
}
