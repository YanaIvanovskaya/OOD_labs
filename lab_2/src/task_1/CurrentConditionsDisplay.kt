package task_1

class CurrentConditionsDisplay : IWeatherDataObserver, IDisplayElement {

    private var mInTemperature: Measurement.Temperature? = null
    private var mInHumidity: Measurement.Humidity? = null
    private var mInPressure: Measurement.Pressure? = null

    private var mOutTemperature: Measurement.Temperature? = null
    private var mOutHumidity: Measurement.Humidity? = null
    private var mOutPressure: Measurement.Pressure? = null

    override fun display() {
        println("CurrentConditionsDisplay:\n" +
                "Temperature IN:${mInTemperature?.value} OUT:${mOutTemperature?.value}\n" +
                "Humidity IN:${mInHumidity?.value} OUT:${mOutHumidity?.value}\n" +
                "Pressure IN:${mInPressure?.value} OUT:${mOutPressure?.value}")
    }

    override fun update(station: Station, measurements: Measurements) {
        val temperature = measurements.getValueOrNull<Measurement.Temperature>()
        val humidity = measurements.getValueOrNull<Measurement.Humidity>()
        val pressure = measurements.getValueOrNull<Measurement.Pressure>()
        when (station) {
            Station.IN -> {
                mInTemperature = temperature
                mInHumidity = humidity
                mInPressure = pressure
            }
            Station.OUT -> {
                mOutTemperature = temperature
                mOutHumidity = humidity
                mOutPressure = pressure
            }
        }
        display()
    }

}

