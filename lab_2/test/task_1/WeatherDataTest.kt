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
        mInWeatherData.registerObserver(mMockObserver2, 2)
        mInWeatherData.registerObserver(mMockObserver1, 1)
        mInWeatherData.registerObserver(mMockObserver3, 3)

        mInWeatherData.notifyObservers()

        inOrder(mMockObserver3, mMockObserver2, mMockObserver1) {
            verify(mMockObserver3, times(1)).update(any(), any())
            verify(mMockObserver2, times(1)).update(any(), any())
            verify(mMockObserver1, times(1)).update(any(), any())
        }
    }

    @Test
    fun `should notify observer with same priority in add order`() {
        mInWeatherData.registerObserver(mMockObserver2, 2)
        mInWeatherData.registerObserver(mMockObserver1, 3)
        mInWeatherData.registerObserver(mMockObserver3, 3)

        mInWeatherData.notifyObservers()

        inOrder(mMockObserver3, mMockObserver2, mMockObserver1) {
            verify(mMockObserver1, times(1)).update(any(), any())
            verify(mMockObserver3, times(1)).update(any(), any())
            verify(mMockObserver2, times(1)).update(any(), any())
        }
    }

    @Test
    fun `should notify observers with current station`() {
        mInWeatherData.registerObserver(mMockObserver1, 1)
        mOutWeatherData.registerObserver(mMockObserver1, 1)

        mInWeatherData.notifyObservers()
        mOutWeatherData.notifyObservers()

        inOrder(mMockObserver1) {
            verify(mMockObserver1, times(1)).update(eq(Station.IN), any())
            verify(mMockObserver1, times(1)).update(eq(Station.OUT), any())
        }
    }

}