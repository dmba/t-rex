package me.dmba.trex.sample.rxjava.redux.reducers

import me.dmba.trex.Reducer
import me.dmba.trex.sample.rxjava.redux.state.ChatAction
import me.dmba.trex.sample.rxjava.redux.state.ChatState
import me.dmba.trex.sample.rxjava.redux.state.MessageAction
import me.dmba.trex.sample.rxjava.redux.state.UserAction
import javax.inject.Inject

/**
 *
 */
class ChatReducer @Inject constructor(

    private val usersReducer: UsersReducer,

    private val msgsReducer: MessagesReducer

) : Reducer<ChatAction, ChatState> {

    override fun reduce(action: ChatAction, state: ChatState): ChatState = when (action) {

        is UserAction -> state.copy(
            users = usersReducer.reduce(action, state.users)
        )

        is MessageAction -> state.copy(
            messages = msgsReducer.reduce(action, state.messages)
        )

    }

}
