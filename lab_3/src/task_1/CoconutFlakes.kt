package task_1

class CoconutFlakes(beverage: IBeverage) : ICondimentDecorator(beverage) {

    override val condimentDescription: String
        get() = " + Coconut flakes"
    override val condimentCost: Int
        get() = 20
}