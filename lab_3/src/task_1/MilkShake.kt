package task_1

class MilkShake(private val portion: Portion) : IBeverage {
    enum class Portion {
        MINI,
        AVERAGE,
        LARGE
    }

    override val description: String
        get() = "Milk shake ${portion.name}"
    override val cost: Int
        get() = when (portion) {
            Portion.MINI -> 50
            Portion.AVERAGE -> 60
            Portion.LARGE -> 80
        }

}
