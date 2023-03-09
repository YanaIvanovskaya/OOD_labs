package task_1

class ChocolateCrumbs(beverage: IBeverage) : ICondimentDecorator(beverage) {

    override val condimentDescription: String
        get() = " + Chocolate crumbs"
    override val condimentCost: Int
        get() = 40
}