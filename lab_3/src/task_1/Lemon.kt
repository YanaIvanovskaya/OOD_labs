package task_1

class Lemon(beverage: IBeverage) : ICondimentDecorator(beverage) {

    override val condimentDescription: String
        get() = " + Lemon"
    override val condimentCost: Int
        get() = 15
}