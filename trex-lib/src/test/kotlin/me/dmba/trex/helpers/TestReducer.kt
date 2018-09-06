package me.dmba.trex.helpers

import me.dmba.trex.Reducer

/**
 *
 */
class TestReducer : Reducer<TestAction, TestState> {

    override fun reduce(action: TestAction, state: TestState): TestState {
        return state.copy(
            age = state.age + 1
        )
    }

}
