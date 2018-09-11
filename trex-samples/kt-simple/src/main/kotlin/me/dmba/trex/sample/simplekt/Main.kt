package me.dmba.trex.sample.simplekt

import me.dmba.trex.sample.simplekt.di.AppComponent
import me.dmba.trex.sample.simplekt.di.DaggerAppComponent
import me.dmba.trex.sample.simplekt.redux.state.AppState
import me.dmba.trex.sample.simplekt.redux.state.CountAction
import me.dmba.trex.sample.simplekt.redux.state.FavAction

/**
 *
 */
fun main(args: Array<String>) {
    DaggerAppComponent
        .create()
        .apply(::run)
}

/**
 *
 */
fun run(component: AppComponent) = with(component) {
    store.subscribe(::renderView)

    listOf(

        CountAction.Add(3),

        CountAction.Sub(2),

        FavAction.MakeFav(),

//        ApiAction.ProduceError,

        CountAction.Add(3),

        CountAction.Sub(2),

        CountAction.Sub(2),

//        ApiAction.ProduceError,

        CountAction.Sub(2),

        CountAction.Sub(2),

//        ApiAction.ProduceError,

        CountAction.Sub(2),

        CountAction.Sub(2)

    ).forEach { store.dispatch(it) }
}

/**
 *
 */
fun renderView(state: AppState) = println("#view: $state")
