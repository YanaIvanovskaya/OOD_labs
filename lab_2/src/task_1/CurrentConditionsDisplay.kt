package task_1

class CurrentConditionsDisplay : IWeatherDataObserver, IDisplayElement {

    private var mTemperature: Measurement.Temperature? = null
    private var mHumidity: Measurement.Humidity? = null
    private var mPressure: Measurement.Pressure? = null

    override fun display() {
        println("CurrentConditionsDisplay:\n" +
                "Temperature ${mTemperature?.value}\n" +
                "Humidity ${mHumidity?.value}\n" +
                "Pressure ${mPressure?.value}")
    }

    override fun update(measurements: Measurements) {
        mTemperature = measurements.getValueOrNull()
        mHumidity = measurements.getValueOrNull()
        mPressure = measurements.getValueOrNull()
        display()
    }

}

