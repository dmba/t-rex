package io.dmba.trex

import io.dmba.trex.redux.AppStore
import io.dmba.trex.redux.reducers.AppReducer
import io.dmba.trex.redux.reducers.CountReducer
import io.dmba.trex.redux.state.ApiAction
import io.dmba.trex.redux.state.CountAction
import io.dmba.trex.redux.state.FavAction
import io.dmba.trex.util.ImmediateScheduler
import io.dmba.trex.util.plusAssign
import io.reactivex.Observable.fromArray
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.dmba.trex.TReXSchedulers
import me.dmba.trex.sample.store.middleware.ApiMiddleware
import me.dmba.trex.sample.store.middleware.LoggingMiddleware
import me.dmba.trex.sample.store.middleware.StorageMiddleware
import me.dmba.trex.sample.store.reducers.FavReducer
import me.dmba.trex.sample.store.state.AppState
import me.dmba.trex.sample.store.state.CountState
import me.dmba.trex.sample.store.state.ErrorState
import me.dmba.trex.sample.store.state.FavState

fun main(args: Array<String>) {
    val store = AppStore(

        TReXSchedulers(
            back = ImmediateScheduler(),
            main = Schedulers.newThread()
        ),

        AppState(
            countState = CountState(
                value = 0
            ),
            favState = FavState(
                isFav = false
            ),
            errorState = ErrorState(
                errors = emptyList()
            )
        ),

        AppReducer(
            CountReducer(),
            FavReducer()
        ),

        LoggingMiddleware(
            doLog = false
        ),

        StorageMiddleware(),

        ApiMiddleware()
    )

    // FUN
    val subscriptions = CompositeDisposable()

    subscriptions += store.subscribe(::renderView, ::handleError)

    fromArray(

        CountAction.Add(3),

        CountAction.Sub(2),

        FavAction.MakeFav(),

        ApiAction.ProduceError(),

        CountAction.Add(3),

        CountAction.Sub(2),

        CountAction.Sub(2),

        ApiAction.ProduceError(),

        CountAction.Sub(2),

        CountAction.Sub(2),

        ApiAction.ProduceError(),

        CountAction.Sub(2),

        CountAction.Sub(2)

    ).forEach { store.dispatch(it) }

    subscriptions.dispose()
}

fun renderView(state: AppState) = println("#view: $state")

fun handleError(error: Throwable) = println("\t!ERROR: $error")
