package me.dmba.trex.sample.simplekt

import io.reactivex.Observable.fromArray
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.dmba.trex.TReXSchedulers
import me.dmba.trex.sample.simplekt.redux.AppStore
import me.dmba.trex.sample.simplekt.redux.middleware.ApiMiddleware
import me.dmba.trex.sample.simplekt.redux.middleware.LoggingMiddleware
import me.dmba.trex.sample.simplekt.redux.reducers.AppReducer
import me.dmba.trex.sample.simplekt.redux.reducers.CountReducer
import me.dmba.trex.sample.simplekt.redux.reducers.FavReducer
import me.dmba.trex.sample.simplekt.redux.state.*
import me.dmba.trex.sample.simplekt.utils.ImmediateScheduler
import me.dmba.trex.sample.simplekt.utils.plusAssign

/**
 *
 */
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

/**
 *
 */
fun renderView(state: AppState) = println("#view: $state")

/**
 *
 */
fun handleError(error: Throwable) = println("\t!ERROR: $error")
