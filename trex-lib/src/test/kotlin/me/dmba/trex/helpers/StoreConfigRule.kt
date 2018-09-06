package me.dmba.trex.helpers

import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations.initMocks
import org.mockito.Spy

/**
 *
 */
class StoreConfigRule : TestWatcher() {

    @Spy
    val schedulers: TestSchedulersProvider = TestSchedulersProvider()

    @Spy
    val initialState: TestState = TestState(0)

    @Spy
    val testReducer: TestReducer = TestReducer()

    @Spy
    lateinit var testMiddleware: TestMiddleware

    @InjectMocks
    lateinit var testStore: TestStore

    override fun starting(description: Description?) = initMocks(this)

}
