package task_3

fun main() {
    val decoyDuck = DecoyDuck()
    decoyDuck.dance()
    decoyDuck.danceBehavior = IDanceBehavior {
        println("I dance with maracas")
    }
    decoyDuck.dance()
    decoyDuck.flyBehaviour = IFlyBehaviour {
        println("I fly in my dreams")
    }
    decoyDuck.fly()

}

