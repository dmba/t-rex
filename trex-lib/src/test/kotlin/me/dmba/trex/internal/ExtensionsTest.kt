package me.dmba.trex.internal

import io.reactivex.Completable.complete
import io.reactivex.Observable
import io.reactivex.Observable.just
import me.dmba.trex.helpers.TestSchedulersProvider
import org.junit.Test

/**
 * Test class for extension functions:
 * - [Observable.with]
 * - [Comparable.with]
 */
class ExtensionsTest {

    private val schedulers = TestSchedulersProvider()

    @Test
    fun `ext for Observable should call subscribeOn and observeOn with provided schedulers`(): Unit = with(schedulers) {
        // Given
        just("item")

            // When
            .with(schedulers)

            // Then
            .test()

            .assertNoValues()
            .also { background.triggerActions() }
            .assertNoValues()
            .also { ui.triggerActions() }
            .assertComplete()

            .assertNoErrors()
            .assertResult("item")
    }

    @Test
    fun `ext for Completable should call subscribeOn and observeOn with provided schedulers`(): Unit = with(schedulers) {
        // Given
        complete()

            // When
            .with(schedulers)

            // Then
            .test()

            .assertNoValues()
            .also { background.triggerActions() }
            .assertNoValues()
            .also { ui.triggerActions() }
            .assertComplete()

            .assertNoErrors()
            .assertResult()
    }

}
