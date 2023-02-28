package task_1

typealias Measurements = Map<Measurement.Key, Measurement>

interface IWeatherDataObserver {
    fun update(measurements: Measurements)
}

interface IWeatherDataObservable {
    fun registerObserver(
            observer: IWeatherDataObserver,
            priority: Int
    )

    fun unregisterObserver(observer: IWeatherDataObserver)
    fun notifyObservers()
}