package task_1

class WeatherData : IObservable {

    private val mMeasurements = mutableMapOf<Measurement.Key, Measurement>()

    private val mObservers = mutableSetOf<IWeatherDataObserver>()

    /**
     * Вызывается при каждом обновлении датчиков
     */
    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(measurements: Measurements) {
        mMeasurements.putAll(measurements)
        measurementsChanged()
    }

    override fun registerObserver(observer: IWeatherDataObserver) {
        mObservers.add(observer)
    }

    override fun unregisterObserver(observer: IWeatherDataObserver) {
        mObservers.add(observer)
    }

    override fun notifyObservers() {
        mObservers.forEach {
            it.update(measurements = mMeasurements)
        }
    }

}