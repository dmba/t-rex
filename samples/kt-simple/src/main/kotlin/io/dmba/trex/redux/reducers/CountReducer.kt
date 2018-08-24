package io.dmba.trex.redux.reducers

import me.dmba.trex.Reducer
import io.dmba.trex.redux.state.CountAction
import me.dmba.trex.sample.store.state.CountState
import javax.inject.Inject

class CountReducer @Inject constructor() : Reducer<CountAction, CountState> {

    override fun reduce(action: CountAction, state: CountState): CountState = when (action) {

        is CountAction.Add -> state.copy(
            value = state.value + action.value
        )

        is CountAction.Sub -> state.copy(
            value = state.value - action.value
        )

    }

}
