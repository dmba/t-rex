package me.dmba.trex.sample.simplekt.redux.state

/**
 *
 */
data class AppState(

    val countState: CountState,

    val favState: FavState

)

/**
 *
 */
data class CountState(

    val value: Int

)

/**
 *
 */
data class FavState(

    val isFav: Boolean

)
