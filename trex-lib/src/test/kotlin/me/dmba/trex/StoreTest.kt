package me.dmba.trex

import me.dmba.trex.helpers.StoreConfigRule
import me.dmba.trex.helpers.TestAction
import me.dmba.trex.helpers.TestState
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify

/**
 * Test class for [Store]
 */
class StoreTest {

    @get:Rule
    val storeConfig = StoreConfigRule()

    @Test
    fun `should apply reducer to initial state`(): Unit = with(storeConfig) {
        // Given
        val testAction = TestAction()

        // When
        testStore.dispatch(testAction)

        // Then
        verify(testReducer).reduce(testAction, initialState)
    }

    @Test
    fun `should apply reducer to previous state`(): Unit = with(storeConfig) {
        // Given
        val testAction = TestAction()

        // When
        testStore.dispatch(testAction)

        val previousState = testStore.lastState

        testStore.dispatch(testAction)

        // Then
        verify(testReducer).reduce(testAction, previousState)
    }

    @Test
    fun `should support multiple subscriptions`(): Unit = with(storeConfig) {
        // Given
        val testAction = TestAction()

        val subscriptions: Array<OnNext<TestState>> = arrayOf(
            { _ -> },
            { _ -> },
            { _ -> }
        )

        subscriptions.forEach { testStore.subscribe(it) }

        // When
        testStore.dispatch(testAction)

        // Then
        subscriptions.forEach {
            verify(it).invoke(testStore.lastState)
        }
    }

    @Test
    fun `should support multiple rx subscriptions`(): Unit = with(storeConfig) {
        // Given
        val testAction = TestAction()

        val subscriptions = arrayOf(
            testStore.state.test(),
            testStore.state.test(),
            testStore.state.test()
        )

        // When
        testStore.dispatch(testAction)

        // Then
        subscriptions.forEach {
            it.assertResult(testStore.lastState)
        }
    }

}
