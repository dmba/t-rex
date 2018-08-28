package me.dmba.trex.sample.simplekt.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import me.dmba.trex.TReXSchedulers
import me.dmba.trex.sample.simplekt.redux.state.AppState
import me.dmba.trex.sample.simplekt.redux.state.CountState
import me.dmba.trex.sample.simplekt.redux.state.ErrorState
import me.dmba.trex.sample.simplekt.redux.state.FavState
import me.dmba.trex.sample.simplekt.utils.ImmediateScheduler

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
        ),
        errorState = ErrorState(
            errors = emptyList()
        )
    )

    @Provides
    @Reusable
    @JvmStatic
    fun provideSchedulers(): TReXSchedulers = TReXSchedulers(
        back = ImmediateScheduler(),
        main = Schedulers.newThread()
    )

}
