package me.dmba.trex.sample.simplekt.redux.middleware

import me.dmba.trex.Middleware
import me.dmba.trex.Next
import me.dmba.trex.Store
import me.dmba.trex.sample.simplekt.redux.state.AppAction
import me.dmba.trex.sample.simplekt.redux.state.AppState
import me.dmba.trex.sample.simplekt.utils.AppLog
import javax.inject.Inject

/**
 *
 */
class LoggingMiddleware @Inject constructor(

    private val log: AppLog

) : Middleware<AppAction, AppState> {

    override fun dispatch(action: AppAction, store: Store<AppAction, AppState>, next: Next<AppAction>) = with(store) {
        log.before("[$action] -> ${state}")
        next(action)
        log.after("[$action] <- ${state}")
    }

}
