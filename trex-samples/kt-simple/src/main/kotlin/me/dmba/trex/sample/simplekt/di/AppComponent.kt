package me.dmba.trex.sample.simplekt.di

import dagger.Component
import me.dmba.trex.sample.simplekt.redux.AppStore

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    val store: AppStore

}
