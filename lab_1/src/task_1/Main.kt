package task_1

fun main() {
    val decoyDuck = DecoyDuck()
    decoyDuck.dance()
    decoyDuck.danceBehavior = MinuetBehaviour()
    decoyDuck.dance()
}