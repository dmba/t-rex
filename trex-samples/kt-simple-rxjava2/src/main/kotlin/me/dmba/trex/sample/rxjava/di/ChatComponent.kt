package me.dmba.trex.sample.rxjava.di

import dagger.Component
import me.dmba.trex.sample.rxjava.redux.ActionCreator
import me.dmba.trex.sample.rxjava.redux.ChatStore

@Component(
    modules = [
        ChatModule::class
    ]
)
interface ChatComponent {

    val store: ChatStore

    val actionCreator: ActionCreator

}
