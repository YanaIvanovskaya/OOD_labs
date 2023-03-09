package task_1

abstract class ICondimentDecorator(
        private val beverage: IBeverage
) : IBeverage {

    abstract val condimentDescription: String
    abstract val condimentCost: Int

    override val description: String
        get() = beverage.description + condimentDescription
    override val cost: Int
        get() = beverage.cost + condimentCost
}

