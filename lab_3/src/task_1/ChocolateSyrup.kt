package task_1

class ChocolateSyrup(beverage: IBeverage) : ICondimentDecorator(beverage) {

    override val condimentDescription: String
        get() = " + ChocolateSyrup"
    override val condimentCost: Int
        get() = 30
}