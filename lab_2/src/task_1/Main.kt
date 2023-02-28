package task_1

fun main() {
    val weatherData = WeatherData()

    val observer1 = CurrentConditionsDisplay()
    val observer2 = AverageTemperatureDisplay()
    weatherData.registerObserver(observer1, 3)
    weatherData.registerObserver(observer2, 9)

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