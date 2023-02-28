package task_1

class AverageTemperatureDisplay : IWeatherDataObserver, IDisplayElement {

    private var mSumOfTemperature = 0.0
    private var mCountOfMeasurements = 0.0

    private var mAverageTemperature = 0.0

    override fun display() {
        println("AverageTemperatureDisplay:\n Average temperature $mAverageTemperature")
    }

    override fun update(measurements: Measurements) {
        val temperature = measurements.getValueOrNull<Measurement.Temperature>()
                ?.value ?: 0.0

        mSumOfTemperature += temperature

        mCountOfMeasurements++
        mAverageTemperature = mSumOfTemperature / mCountOfMeasurements

        display()
    }
}