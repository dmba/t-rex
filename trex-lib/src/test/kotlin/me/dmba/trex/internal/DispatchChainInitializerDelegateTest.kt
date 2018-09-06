package me.dmba.trex.internal

import me.dmba.trex.Next
import me.dmba.trex.helpers.StoreConfigRule
import me.dmba.trex.helpers.TestAction
import me.dmba.trex.helpers.TestState
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import kotlin.reflect.KProperty

/**
 * Test class for [DispatchChainInitializerDelegate]
 */
internal class DispatchChainInitializerDelegateTest {

    @get:Rule
    val storeConfig = StoreConfigRule()

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var anyProperty: KProperty<*>

    val delegate = DispatchChainInitializerDelegate<TestAction, TestState>()

    @Test
    fun `should initialize dispatch chain`(): Unit = with(storeConfig) {
        // When
        val value = delegate.getValue(testStore, anyProperty)

        // Then
        assertThat(value).isNotNull
    }

    @Test
    fun `should provide reducer dispatcher`(): Unit = with(storeConfig) {
        // Given

        // When
        val reducerDispatcher = delegate.provideReducerDispatcher(testStore)

        // Then
        assertThat(reducerDispatcher).isNotNull
    }

    @Test
    fun `should provide middleware dispatcher`(): Unit = with(storeConfig) {
        // Given

        // When
        val middlewareDispatcher = delegate.provideMiddlewareDispatcher(testStore)

        // Then
        assertThat(middlewareDispatcher).isNotNull
    }

    @Test
    fun `should provide action dispatcher`(): Unit = with(storeConfig) {
        // Given
        val next: Next<TestAction> = {}

        // When
        val actionDispatcher = delegate.provideActionDispatcher(testStore, next, testMiddleware)

        // Then
        assertThat(actionDispatcher).isNotNull
    }

}
