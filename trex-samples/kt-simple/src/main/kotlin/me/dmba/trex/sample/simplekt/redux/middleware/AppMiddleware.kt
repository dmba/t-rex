package me.dmba.trex.sample.simplekt.redux.middleware

import me.dmba.trex.Middleware
import me.dmba.trex.sample.simplekt.redux.state.AppAction
import me.dmba.trex.sample.simplekt.redux.state.AppState

/**
 *
 */
interface AppMiddleware : Middleware<AppAction, AppState>
