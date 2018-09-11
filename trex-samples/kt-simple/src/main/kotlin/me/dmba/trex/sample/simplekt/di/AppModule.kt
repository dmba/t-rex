package me.dmba.trex.sample.simplekt.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import me.dmba.trex.sample.simplekt.redux.state.AppState
import me.dmba.trex.sample.simplekt.redux.state.CountState
import me.dmba.trex.sample.simplekt.redux.state.FavState

@Module
object AppModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideInitialAppState(): AppState = AppState(
        countState = CountState(
            value = 0
        ),
        favState = FavState(
            isFav = false
        )
    )

}
