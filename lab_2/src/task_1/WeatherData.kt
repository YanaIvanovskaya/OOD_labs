package task_1

import java.util.*

class WeatherData(
        private val station: Station
) : IWeatherDataObservable {

    private val mMeasurements = mutableMapOf<Measurement.Key, Measurement>()

    private val mObservers =
            TreeMap<Int, MutableMap<IWeatherDataObserver, Set<Measurement.Key>?>>(Comparator.reverseOrder())

    private val mLastSentMeasurements = mutableListOf<Measurement>()

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
            priority: Int,
            measurements: Set<Measurement.Key>?
    ) {
        require(priority >= 0) { "Priority must be positive" }

        val observers = mObservers[priority] ?: mutableMapOf()
        observers[observer] = measurements ?: Measurement.Key.values().toSet()
        mObservers[priority] = observers
    }

    override fun unregisterObserver(
            observer: IWeatherDataObserver,
            measurements: Set<Measurement.Key>?
    ) {
        var priority = 0
        var currentMeasurements: Set<Measurement.Key>? = emptySet()

        mObservers.forEach { (p, observers) ->
            currentMeasurements = observers.remove(observer)
            if (observers.remove(observer) != null) {
                priority = p
                return@forEach
            }
        }

        if (measurements != null) {
            registerObserver(observer, priority, currentMeasurements?.minus(measurements))
        }
    }

    override fun notifyObservers() {
        if (mMeasurements.isEmpty()) return

        val distinctMeasurements = mMeasurements
                .filterValues { it !in mLastSentMeasurements }

        mLastSentMeasurements.clear()
        mObservers.values.forEach { observers ->
            observers.forEach { (observer, keys) ->
                val measurements = distinctMeasurements
                        .filterKeys { it in (keys ?: emptySet()) }

                mLastSentMeasurements.addAll(measurements.values)

                if (measurements.isNotEmpty()) {
                    observer.update(
                            station = station,
                            measurements = measurements
                    )
                }
            }
        }
    }

}