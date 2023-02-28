package task_1

inline fun <reified T : Measurement> Measurements.getValueOrNull(): T? {
    val key = when (T::class) {
        Measurement.Temperature::class -> Measurement.Key.TEMPERATURE
        Measurement.Humidity::class -> Measurement.Key.HUMIDITY
        Measurement.Pressure::class -> Measurement.Key.PRESSURE
        Measurement.WindPower::class -> Measurement.Key.WIND_POWER
        Measurement.RadiationLevel::class -> Measurement.Key.RADIATION_LEVEL
        else -> null
    }
    return (this[key] as? T)
}