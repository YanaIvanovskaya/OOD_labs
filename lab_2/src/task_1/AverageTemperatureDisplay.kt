package task_1

class AverageTemperatureDisplay : IWeatherDataObserver, IDisplayElement {

    private var mInSumOfTemperature = 0.0
    private var mInCountOfMeasurements = 0.0
    private var mInAverageTemperature = 0.0

    private var mOutSumOfTemperature = 0.0
    private var mOutCountOfMeasurements = 0.0
    private var mOutAverageTemperature = 0.0

    override fun display() {
        println("AverageTemperatureDisplay:\n" +
                " IN Average temperature $mInAverageTemperature\n" +
                "OUT Average temperature $mOutAverageTemperature")
    }

    override fun update(station: Station, measurements: Measurements) {
        val temperature = measurements.getValueOrNull<Measurement.Temperature>()
                ?.value ?: 0.0

        when (station) {
            Station.IN -> {
                mInSumOfTemperature += temperature

                mInCountOfMeasurements++
                mInAverageTemperature = mInSumOfTemperature / mInCountOfMeasurements
            }
            Station.OUT -> {
                mOutSumOfTemperature += temperature

                mOutCountOfMeasurements++
                mOutAverageTemperature = mOutSumOfTemperature / mOutCountOfMeasurements
            }
        }

        display()
    }
}