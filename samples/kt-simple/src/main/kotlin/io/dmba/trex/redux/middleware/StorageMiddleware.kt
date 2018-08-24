package me.dmba.trex.sample.store.middleware

import me.dmba.trex.Middleware
import me.dmba.trex.Next
import me.dmba.trex.Store
import io.dmba.trex.redux.state.AppAction
import me.dmba.trex.sample.store.state.AppState
import javax.inject.Inject

class StorageMiddleware @Inject constructor() : Middleware<AppAction, AppState> {

    override fun dispatch(action: AppAction, store: Store<AppAction, AppState>, next: Next<AppAction>) {
        next(action)
    }

}
