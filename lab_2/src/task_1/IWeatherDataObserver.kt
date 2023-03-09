package task_1

typealias Measurements = Map<Measurement.Key, Measurement>

interface IWeatherDataObserver {
    fun update(station: Station, measurements: Measurements)
}

interface IWeatherDataObservable {
    //    if  measurements == null  observer will be notified about all changes
    fun registerObserver(
            observer: IWeatherDataObserver,
            priority: Int,
            measurements: Set<Measurement.Key>? = null
    )

//    if  measurements == null  observer will be deleted completely
    fun unregisterObserver(
            observer: IWeatherDataObserver,
            measurements: Set<Measurement.Key>? = null
    )

    fun notifyObservers()
}