package task_1

fun main() {
    val a = Coffee.Capiccino(Coffee.Portion.DOUBLE)
    val b = Cinnamon(a)
    val c = Ice(b)

    println(c.description)
    println(c.cost)
}