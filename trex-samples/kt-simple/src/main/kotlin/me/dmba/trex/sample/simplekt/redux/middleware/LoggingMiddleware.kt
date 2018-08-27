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
class LoggingMiddleware @Inject constructor(

    private val doLog: Boolean = true

) : Middleware<AppAction, AppState> {

    override fun dispatch(action: AppAction, store: Store<AppAction, AppState>, next: Next<AppAction>) {
        if (doLog) println("APP : ${Thread.currentThread()} before [$action] >> ${store.state}")
        next(action)
        if (doLog) println("APP : ${Thread.currentThread()} after  [$action] << ${store.state}")
    }

}