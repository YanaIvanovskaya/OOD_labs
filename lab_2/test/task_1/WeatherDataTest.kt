package task_1

import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

internal class WeatherDataTest {

    private val mMockObserver1 = mock<IWeatherDataObserver>()
    private val mMockObserver2 = mock<IWeatherDataObserver>()
    private val mMockObserver3 = mock<IWeatherDataObserver>()
    private val mInWeatherData = WeatherData(Station.IN)
    private val mOutWeatherData = WeatherData(Station.OUT)

    @Test
    fun `should notify observer with higher priority by first`() {
        val measurements = mapOf(Measurement.Key.TEMPERATURE to Measurement.Temperature(12.9))

        mInWeatherData.registerObserver(mMockObserver2, 2)
        mInWeatherData.registerObserver(mMockObserver1, 1)
        mInWeatherData.registerObserver(mMockObserver3, 3)

        mInWeatherData.setMeasurements(measurements)

        inOrder(mMockObserver3, mMockObserver2, mMockObserver1) {
            verify(mMockObserver3, times(1)).update(any(), any())
            verify(mMockObserver2, times(1)).update(any(), any())
            verify(mMockObserver1, times(1)).update(any(), any())
        }
    }

    @Test
    fun `should notify observer with same priority in add order`() {
        val measurements = mapOf(Measurement.Key.TEMPERATURE to Measurement.Temperature(12.9))

        mInWeatherData.registerObserver(mMockObserver2, 2)
        mInWeatherData.registerObserver(mMockObserver1, 3)
        mInWeatherData.registerObserver(mMockObserver3, 3)

        mInWeatherData.setMeasurements(measurements)

        inOrder(mMockObserver3, mMockObserver2, mMockObserver1) {
            verify(mMockObserver1, times(1)).update(any(), any())
            verify(mMockObserver3, times(1)).update(any(), any())
            verify(mMockObserver2, times(1)).update(any(), any())
        }
    }

    @Test
    fun `should notify observers with current station`() {
        val measurements1 = mapOf(Measurement.Key.TEMPERATURE to Measurement.Temperature(12.9))
        val measurements2 = mapOf(Measurement.Key.TEMPERATURE to Measurement.Temperature(40.9))

        mInWeatherData.registerObserver(mMockObserver1, 1)
        mOutWeatherData.registerObserver(mMockObserver1, 1)

        mInWeatherData.setMeasurements(measurements1)
        mOutWeatherData.setMeasurements(measurements2)

        inOrder(mMockObserver1) {
            verify(mMockObserver1, times(1)).update(eq(Station.IN), any())
            verify(mMockObserver1, times(1)).update(eq(Station.OUT), any())
        }
    }

    @Test
    fun `should notify observer if desired measurement changed`() {
        val measurements = mapOf(Measurement.Key.RADIATION_LEVEL to Measurement.RadiationLevel(12))
        mInWeatherData.registerObserver(mMockObserver1, 1, setOf(Measurement.Key.RADIATION_LEVEL))
        mInWeatherData.setMeasurements(measurements)

        verify(mMockObserver1, times(1)).update(eq(Station.IN), eq(measurements))
    }

    @Test
    fun `should NOT notify observer if desired measurement NOT changed`() {
        val measurements = mapOf(Measurement.Key.RADIATION_LEVEL to Measurement.RadiationLevel(12))
        mInWeatherData.registerObserver(mMockObserver1, 1, setOf(Measurement.Key.TEMPERATURE))
        mInWeatherData.setMeasurements(measurements)

        verify(mMockObserver1, never()).update(any(), any())
    }

    @Test
    fun `should NOT notify observer if it unregistered`() {
        val measurements1 = mapOf(Measurement.Key.RADIATION_LEVEL to Measurement.RadiationLevel(12))
        val measurements2 = mapOf(Measurement.Key.RADIATION_LEVEL to Measurement.RadiationLevel(15))

        mInWeatherData.registerObserver(mMockObserver1, 1, setOf(Measurement.Key.RADIATION_LEVEL))
        mInWeatherData.setMeasurements(measurements1)

        mInWeatherData.unregisterObserver(mMockObserver1)
        mInWeatherData.setMeasurements(measurements2)

        verify(mMockObserver1, times(1)).update(eq(Station.IN), eq(measurements1))
        verify(mMockObserver1, never()).update(eq(Station.IN), eq(measurements2))
    }

    @Test
    fun `should NOT notify observer if it unregistered from concrete measurements`() {
        val measurements1 = mapOf(
                Measurement.Key.RADIATION_LEVEL to Measurement.RadiationLevel(12),
                Measurement.Key.PRESSURE to Measurement.Pressure(90.0),
        )
        val measurements2 = mapOf(Measurement.Key.PRESSURE to Measurement.Pressure(120.5))

        mInWeatherData.registerObserver(mMockObserver1, 1, setOf(
                Measurement.Key.RADIATION_LEVEL,
                Measurement.Key.PRESSURE
        ))
        mInWeatherData.setMeasurements(measurements1)

        mInWeatherData.unregisterObserver(mMockObserver1, setOf(
                Measurement.Key.PRESSURE
        ))
        mInWeatherData.setMeasurements(measurements2)

        verify(mMockObserver1, times(1)).update(eq(Station.IN), eq(measurements1))
        verify(mMockObserver1, never()).update(eq(Station.IN), eq(measurements2))
    }

    @Test
    fun `should NOT notify observer if new value equal old value`() {
        val measurements1 = mapOf(
                Measurement.Key.RADIATION_LEVEL to Measurement.RadiationLevel(12),
                Measurement.Key.PRESSURE to Measurement.Pressure(90.0),
        )
        val measurements2 = mapOf(Measurement.Key.PRESSURE to Measurement.Pressure(90.0))

        mInWeatherData.registerObserver(mMockObserver1, 1)
        mInWeatherData.setMeasurements(measurements1)
        mInWeatherData.setMeasurements(measurements2)

        verify(mMockObserver1, times(1)).update(eq(Station.IN), eq(measurements1))
        verify(mMockObserver1, never()).update(eq(Station.IN), eq(measurements2))
    }

}