package me.dmba.trex.sample.simplekt.redux.reducers

import me.dmba.trex.Reducer
import me.dmba.trex.sample.simplekt.redux.state.CountAction
import me.dmba.trex.sample.simplekt.redux.state.CountState
import javax.inject.Inject

/**
 *
 */
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
