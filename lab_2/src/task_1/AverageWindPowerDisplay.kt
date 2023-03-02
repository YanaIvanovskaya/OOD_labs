package task_1

class AverageWindPowerDisplay : IWeatherDataObserver, IDisplayElement {

    private val mSumOfWindSpeed = mutableMapOf<Measurement.WindPower.Direction, Double>()
    private val mCountOfMeasurements = mutableMapOf<Measurement.WindPower.Direction, Int>()
    private val mAverageWindSpeed = mutableMapOf<Measurement.WindPower.Direction, Double>()

    override fun display() {
        println("AverageWindPowerDisplay")
        mAverageWindSpeed.forEach { (t, u) ->
            println("$t : $u")
        }
    }

    override fun update(station: Station, measurements: Measurements) {
        val windPower = measurements.getValueOrNull<Measurement.WindPower>() ?: return

        val sumOfSpeed = mSumOfWindSpeed.getOrDefault(windPower.direction, 0.0) + windPower.speed
        mSumOfWindSpeed[windPower.direction] = sumOfSpeed

        val count = mCountOfMeasurements.getOrDefault(windPower.direction, 0) + 1
        mCountOfMeasurements[windPower.direction] = count

        mAverageWindSpeed[windPower.direction] = sumOfSpeed / count

        display()
    }

}