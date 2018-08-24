package io.dmba.trex.redux.reducers

import io.dmba.trex.redux.state.AppAction
import io.dmba.trex.redux.state.CountAction
import io.dmba.trex.redux.state.FavAction
import me.dmba.trex.Reducer
import me.dmba.trex.sample.store.reducers.FavReducer
import me.dmba.trex.sample.store.state.AppState
import javax.inject.Inject

class AppReducer @Inject constructor(

    private val countReducer: CountReducer,

    private val favReducer: FavReducer

) : Reducer<AppAction, AppState> {

    override fun reduce(action: AppAction, state: AppState): AppState = when (action) {

        is CountAction -> state.copy(
            countState = countReducer.reduce(action, state.countState)
        )

        is FavAction -> state.copy(
            favState = favReducer.reduce(action, state.favState)
        )

        else -> state

    }

}
