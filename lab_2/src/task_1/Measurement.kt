package task_1

sealed interface Measurement {

    data class Temperature(val value: Double) : Measurement

    data class Humidity(val value: Double) : Measurement

    data class Pressure(val value: Double) : Measurement

    data class WindPower(val value: Int) : Measurement

    data class RadiationLevel(val value: Int) : Measurement

    enum class Key {
        TEMPERATURE,
        HUMIDITY,
        PRESSURE,
        WIND_POWER,
        RADIATION_LEVEL
    }

}