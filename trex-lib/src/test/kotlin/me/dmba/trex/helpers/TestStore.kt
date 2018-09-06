package me.dmba.trex.helpers

import me.dmba.trex.Store

class TestStore constructor(

    initialState: TestState,

    appReducer: TestReducer,

    testMiddleware: TestMiddleware,

    schedulers: TestSchedulersProvider

) : Store<TestAction, TestState>(

    initialState,

    appReducer,

    testMiddleware,

    schedulers = schedulers

)
