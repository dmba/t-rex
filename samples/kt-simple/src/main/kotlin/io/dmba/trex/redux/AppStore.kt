package io.dmba.trex.redux

import me.dmba.trex.Store
import me.dmba.trex.TReXSchedulers
import me.dmba.trex.sample.store.middleware.ApiMiddleware
import me.dmba.trex.sample.store.middleware.LoggingMiddleware
import me.dmba.trex.sample.store.middleware.StorageMiddleware
import io.dmba.trex.redux.reducers.AppReducer
import io.dmba.trex.redux.state.AppAction
import me.dmba.trex.sample.store.state.AppState
import javax.inject.Inject

class AppStore @Inject constructor(

    schedulers: TReXSchedulers,

    initialState: AppState,

    appReducer: AppReducer,

    loggingMiddleware: LoggingMiddleware,

    storageMiddleware: StorageMiddleware,

    apiMiddleware: ApiMiddleware

) : Store<AppAction, AppState>(schedulers, initialState, appReducer, loggingMiddleware, storageMiddleware, apiMiddleware)
