package task_1

fun main() {
    val decoyDuck = DecoyDuck()
    decoyDuck.dance()
    decoyDuck.danceBehavior = MinuetBehaviour()
    decoyDuck.dance()
    decoyDuck.flyBehaviour = FlyBehaviour()
    decoyDuck.fly()
    decoyDuck.fly()
    decoyDuck.fly()
    decoyDuck.fly()
    decoyDuck.fly()
    decoyDuck.flyBehaviour = IFlyBehaviour.NoWay
    decoyDuck.fly()
    decoyDuck.fly()
    decoyDuck.flyBehaviour = FlyBehaviour()
    decoyDuck.fly()
    decoyDuck.fly()
}