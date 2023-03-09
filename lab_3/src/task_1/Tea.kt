package task_1

sealed interface Tea : IBeverage {
    override val description: String
        get() = "Tea"
    override val cost: Int
        get() = 30

    class Black : Tea {
        override val description: String
            get() = super.description + " 'Black'"
    }

    class Green : Tea {
        override val description: String
            get() = super.description + " 'Green'"
    }

    class Red : Tea {
        override val description: String
            get() = super.description + " 'Red'"
    }

    class MintMix : Tea {
        override val description: String
            get() = super.description + " 'MintMix'"
    }
}