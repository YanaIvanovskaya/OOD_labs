package task_1

sealed interface Measurement {

    data class Temperature(val value: Double) : Measurement

    data class Humidity(val value: Double) : Measurement

    data class Pressure(val value: Double) : Measurement

    data class WindPower(
            val speed: Int,
            val direction: Direction
    ) : Measurement {
        enum class Direction {
            NORTH,
            SOUTH,
            WEST,
            EAST
        }
    }

    data class RadiationLevel(val value: Int) : Measurement

    enum class Key {
        TEMPERATURE,
        HUMIDITY,
        PRESSURE,
        WIND_POWER,
        RADIATION_LEVEL
    }

}