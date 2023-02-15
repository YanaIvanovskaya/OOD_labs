package task_1

abstract class Duck {
    abstract var danceBehavior: IDanceBehavior
    abstract var flyBehaviour: IFlyBehaviour

    fun dance() = danceBehavior.dance()
    fun fly() = flyBehaviour.fly()
}

class MallardDuck : Duck() {
    override var danceBehavior: IDanceBehavior = WaltzBehaviour()
    override var flyBehaviour: IFlyBehaviour = FlyBehaviour()
}

class RedHeadDuck : Duck() {
    override var danceBehavior: IDanceBehavior = MinuetBehaviour()
    override var flyBehaviour: IFlyBehaviour = FlyBehaviour()
}

class RubberDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior.NoDance
    override var flyBehaviour: IFlyBehaviour = IFlyBehaviour.NoWay
}

class DecoyDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior.NoDance
    override var flyBehaviour: IFlyBehaviour = IFlyBehaviour.NoWay
}