package me.dmba.trex.sample.simplekt.redux.middleware

import me.dmba.trex.Middleware
import me.dmba.trex.Next
import me.dmba.trex.Store
import me.dmba.trex.sample.simplekt.redux.state.ApiAction
import me.dmba.trex.sample.simplekt.redux.state.AppAction
import me.dmba.trex.sample.simplekt.redux.state.AppState
import javax.inject.Inject

/**
 *
 */
class ApiMiddleware @Inject constructor() : Middleware<AppAction, AppState> {

    override fun dispatch(action: AppAction, store: Store<AppAction, AppState>, next: Next<AppAction>) = when (action) {

        is ApiAction.ProduceError -> throw Error("Ups!")

        else -> next(action)

    }

}
