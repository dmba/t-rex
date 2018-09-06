package me.dmba.trex.sample.simplekt.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import me.dmba.trex.SchedulersProvider
import me.dmba.trex.sample.simplekt.redux.state.AppState
import me.dmba.trex.sample.simplekt.redux.state.CountState
import me.dmba.trex.sample.simplekt.redux.state.FavState
import me.dmba.trex.sample.simplekt.utils.ImmediateScheduler

@Module(
    includes = [
        AppModuleBindings::class
    ]
)
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

    @Provides
    @Reusable
    @JvmStatic
    fun provideSchedulers(): SchedulersProvider = object : SchedulersProvider {

        override val ui = ImmediateScheduler()

        override val background = ImmediateScheduler()

    }

}

@Module
interface AppModuleBindings
