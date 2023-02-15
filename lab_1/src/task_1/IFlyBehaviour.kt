package task_1

interface IFlyBehaviour {
    fun fly()

    companion object NoWay : IFlyBehaviour {
        override fun fly() {
            println("I can not fly(")
        }
    }
}

class FlyBehaviour : IFlyBehaviour {

    private var mCounter = 0

    override fun fly() {
        println("I believe i can fly! - $mCounter")
        mCounter++
    }
}