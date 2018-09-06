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
class RxExtTest {

    private val testSchedulers = TestSchedulersProvider()

    @Test
    fun `extension for Observable should call subscribeOn and observeOn with provided schedulers`() {
        // Given
        just("item")

            // When
            .with(testSchedulers)

            // Then
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult("item")
            .assertOf {

            }
    }

    @Test
    fun `extension for Completable should call subscribeOn and observeOn with provided schedulers`() {
        // Given
        complete()

            // When
            .with(testSchedulers)

            // Then
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertResult()
            .assertOf {

            }
    }

}
