package me.dmba.trex.sample.rxjava.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers.io
import io.reactivex.schedulers.Schedulers.newThread
import me.dmba.trex.SchedulersProvider
import me.dmba.trex.sample.rxjava.redux.state.ChatState

/**
 *
 */
@Module
object ChatModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideInitialAppState(): ChatState = ChatState(
        users = listOf(),
        messages = listOf()
    )

    @Provides
    @Reusable
    @JvmStatic
    fun provideSchedulers(): SchedulersProvider = object : SchedulersProvider {
        override val ui: Scheduler
            get() = newThread()

        override val background: Scheduler
            get() = io()
    }

}
