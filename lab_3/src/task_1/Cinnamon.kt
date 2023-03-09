package task_1

class Cinnamon(beverage: IBeverage) : ICondimentDecorator(beverage) {

    override val condimentDescription: String
        get() = " + Cinnamon"
    override val condimentCost: Int
        get() = 20
}