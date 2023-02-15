package task_1

abstract class Duck {
    abstract val danceBehavior: IDanceBehavior

    fun dance() = danceBehavior.dance()
}

class MallardDuck : Duck() {
    override var danceBehavior: IDanceBehavior = WaltzBehaviour()
}

class RedHeadDuck : Duck() {
    override var danceBehavior: IDanceBehavior = MinuetBehaviour()
}

class RubberDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior.NoDance
}

class DecoyDuck : Duck() {
    override var danceBehavior: IDanceBehavior = IDanceBehavior.NoDance
}