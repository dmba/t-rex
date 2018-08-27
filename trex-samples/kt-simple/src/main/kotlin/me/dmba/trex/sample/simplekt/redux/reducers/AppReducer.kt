package me.dmba.trex.sample.simplekt.redux.reducers

import me.dmba.trex.Reducer
import me.dmba.trex.sample.simplekt.redux.state.AppAction
import me.dmba.trex.sample.simplekt.redux.state.AppState
import me.dmba.trex.sample.simplekt.redux.state.CountAction
import me.dmba.trex.sample.simplekt.redux.state.FavAction
import javax.inject.Inject

/**
 *
 */
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
