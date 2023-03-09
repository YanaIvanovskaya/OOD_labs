package task_1

sealed class Coffee(val portion: Portion) : IBeverage {
    enum class Portion {
        STANDARD,
        DOUBLE
    }

    class Capiccino(portion: Portion) : Coffee(portion) {
        override val description: String
            get() = "Capiccino ${portion.name}"
        override val cost: Int
            get() = when (portion) {
                Portion.STANDARD -> 80
                Portion.DOUBLE -> 120
            }
    }

    class Latte(portion: Portion) : Coffee(portion) {
        override val description: String
            get() = "Latte ${portion.name}"
        override val cost: Int
            get() = when (portion) {
                Portion.STANDARD -> 90
                Portion.DOUBLE -> 130
            }
    }

}