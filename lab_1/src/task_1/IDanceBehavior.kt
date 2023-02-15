package task_1

interface IDanceBehavior {
    fun dance()

    companion object NoDance : IDanceBehavior {
        override fun dance() {
            println("I can not dance(")
        }
    }
}

class WaltzBehaviour : IDanceBehavior {
    override fun dance() {
        println("I dance the waltz")
    }
}

class MinuetBehaviour : IDanceBehavior {
    override fun dance() {
        println("I dance the minuet")
    }
}