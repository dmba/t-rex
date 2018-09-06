package me.dmba.trex.sample.simplekt.redux

import dagger.Reusable
import me.dmba.trex.Store
import me.dmba.trex.sample.simplekt.redux.middleware.ApiMiddleware
import me.dmba.trex.sample.simplekt.redux.middleware.LoggingMiddleware
import me.dmba.trex.sample.simplekt.redux.reducers.AppReducer
import me.dmba.trex.sample.simplekt.redux.state.AppAction
import me.dmba.trex.sample.simplekt.redux.state.AppState
import javax.inject.Inject

/**
 *
 */
@Reusable
class AppStore @Inject constructor(

    initialState: AppState,

    appReducer: AppReducer,

    loggingMiddleware: LoggingMiddleware,

    apiMiddleware: ApiMiddleware

) : Store<AppAction, AppState>(

    initialState,

    appReducer,

    loggingMiddleware,

    apiMiddleware

)
