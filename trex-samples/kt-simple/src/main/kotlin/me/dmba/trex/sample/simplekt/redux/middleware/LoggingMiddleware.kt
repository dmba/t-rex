package me.dmba.trex.sample.simplekt.redux.middleware

import me.dmba.trex.Middleware
import me.dmba.trex.Next
import me.dmba.trex.Store
import me.dmba.trex.sample.simplekt.redux.state.AppAction
import me.dmba.trex.sample.simplekt.redux.state.AppState
import javax.inject.Inject

/**
 *
 */
class LoggingMiddleware @Inject constructor() : Middleware<AppAction, AppState> {

    override fun dispatch(action: AppAction, store: Store<AppAction, AppState>, next: Next<AppAction>) {
        println("APP : ${Thread.currentThread()} before [$action] >> ${store.first}")
        next(action)
        println("APP : ${Thread.currentThread()} after  [$action] << ${store.first}")
    }

}
