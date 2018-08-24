package me.dmba.trex.sample.store.state

data class AppState(

    val countState: CountState,

    val favState: FavState,

    val errorState: ErrorState

)

data class CountState(

    val value: Int

)

data class FavState(

    val isFav: Boolean

)

data class ErrorState(

    val errors: List<Throwable>

)
