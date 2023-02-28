package task_1

typealias Measurements = Map<Measurement.Key, Measurement>

interface IWeatherDataObserver {
    fun update(measurements: Measurements)
}

interface IObservable {
    fun registerObserver(observer: IWeatherDataObserver)
    fun unregisterObserver(observer: IWeatherDataObserver)
    fun notifyObservers()
}