package task_3

abstract class Duck {
    abstract var danceBehavior: IDanceBehavior
    abstract var flyBehaviour: IFlyBehaviour

    fun dance() = danceBehavior()
    fun fly() = flyBehaviour()
}

class MallardDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior {
        println("I dance the waltz")
    }
    override var flyBehaviour: IFlyBehaviour = IFlyBehaviour {
        println("I believe i can fly!")
    }
}

class RedHeadDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior {
        println("I dance the minuet")
    }
    override var flyBehaviour: IFlyBehaviour = IFlyBehaviour {
        println("I believe i can fly!")
    }
}

class RubberDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior {}
    override var flyBehaviour: IFlyBehaviour = IFlyBehaviour {}
}

class DecoyDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior {}
    override var flyBehaviour: IFlyBehaviour = IFlyBehaviour {}
}