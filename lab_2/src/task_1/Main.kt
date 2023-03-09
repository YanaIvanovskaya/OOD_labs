package task_1

fun main() {
//    val weatherData1 = WeatherData(Station.OUT)
//    val weatherData2 = WeatherData(Station.IN)
//
//    val observer1 = CurrentConditionsDisplay()
//    val observer2 = AverageTemperatureDisplay()
//    weatherData1.registerObserver(observer1, 3)
//    weatherData1.registerObserver(observer2, 9)
//
//    weatherData2.registerObserver(observer1, 3)
//    weatherData2.registerObserver(observer2, 9)
//
//    weatherData1.setMeasurements(
//            mapOf(
//                    Measurement.Key.TEMPERATURE to Measurement.Temperature(20.0),
//                    Measurement.Key.HUMIDITY to Measurement.Humidity(12.0)
//            )
//    )
//
//    weatherData1.setMeasurements(
//            mapOf(
//                    Measurement.Key.TEMPERATURE to Measurement.Temperature(25.0),
//                    Measurement.Key.HUMIDITY to Measurement.Humidity(22.0)
//            )
//    )
//
//    weatherData2.setMeasurements(
//            mapOf(
//                    Measurement.Key.TEMPERATURE to Measurement.Temperature(29.0),
//                    Measurement.Key.HUMIDITY to Measurement.Humidity(12.0)
//            )
//    )

    val weatherData = WeatherData(Station.OUT)
    val observer = AverageWindPowerDisplay()

    weatherData.registerObserver(observer, 1, setOf(Measurement.Key.TEMPERATURE))

    weatherData.setMeasurements(mapOf(
            Measurement.Key.WIND_POWER to
                    Measurement.WindPower(20, Measurement.WindPower.Direction.EAST)
    ))
    weatherData.setMeasurements(mapOf(
            Measurement.Key.TEMPERATURE to
                    Measurement.Temperature(50.0)
    ))

    weatherData.registerObserver(observer, 1, setOf(Measurement.Key.WIND_POWER))

    weatherData.setMeasurements(mapOf(
            Measurement.Key.WIND_POWER to
                    Measurement.WindPower(10, Measurement.WindPower.Direction.EAST)
    ))
    weatherData.setMeasurements(mapOf(
            Measurement.Key.TEMPERATURE to
                    Measurement.Temperature(50.0)
    ))

}