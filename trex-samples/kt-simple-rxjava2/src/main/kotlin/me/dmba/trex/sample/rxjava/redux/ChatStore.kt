package me.dmba.trex.sample.rxjava.redux

import dagger.Reusable
import me.dmba.trex.RxStore
import me.dmba.trex.SchedulersProvider
import me.dmba.trex.sample.rxjava.redux.reducers.ChatReducer
import me.dmba.trex.sample.rxjava.redux.state.ChatAction
import me.dmba.trex.sample.rxjava.redux.state.ChatState
import javax.inject.Inject

/**
 *
 */
@Reusable
class ChatStore @Inject constructor(

    schedulers: SchedulersProvider,

    initialState: ChatState,

    appReducer: ChatReducer

) : RxStore<ChatAction, ChatState>(

    schedulers,

    initialState,

    appReducer

)
