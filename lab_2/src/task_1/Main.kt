package task_1

fun main() {
    val weatherData = WeatherData()

    weatherData.registerObserver(CurrentConditionsDisplay())
    weatherData.registerObserver(AverageTemperatureDisplay())

    weatherData.setMeasurements(
            mapOf(
                    Measurement.Key.TEMPERATURE to Measurement.Temperature(20.0),
                    Measurement.Key.HUMIDITY to Measurement.Humidity(12.0)
            )
    )

    weatherData.setMeasurements(
            mapOf(
                    Measurement.Key.TEMPERATURE to Measurement.Temperature(25.0),
                    Measurement.Key.HUMIDITY to Measurement.Humidity(22.0)
            )
    )

}