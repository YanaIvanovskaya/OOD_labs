package task_1

import java.util.*

class WeatherData : IWeatherDataObservable {

    private val mMeasurements = mutableMapOf<Measurement.Key, Measurement>()

    private val mObservers = TreeMap<Int, MutableSet<IWeatherDataObserver>>(Comparator.reverseOrder())

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

    override fun registerObserver(
            observer: IWeatherDataObserver,
            priority: Int
    ) {
        val observers = mObservers[priority] ?: mutableSetOf()
        observers.add(observer)
        mObservers[priority] = observers
    }

    override fun unregisterObserver(observer: IWeatherDataObserver) {
        mObservers.forEach { (_, observers) ->
            observers.remove(observer)
        }
    }

    override fun notifyObservers() {
        mObservers.values.forEach { observers ->
            Thread.sleep(500)
            observers.forEach { it.update(measurements = mMeasurements) }
        }
    }

}