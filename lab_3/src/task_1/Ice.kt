package task_1

class Ice(beverage: IBeverage) : ICondimentDecorator(beverage) {

    override val condimentDescription: String
        get() = " + Ice"
    override val condimentCost: Int
        get() = 10
}