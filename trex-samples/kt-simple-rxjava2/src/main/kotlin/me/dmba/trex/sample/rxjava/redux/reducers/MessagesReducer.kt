package me.dmba.trex.sample.rxjava.redux.reducers

import me.dmba.trex.Reducer
import me.dmba.trex.sample.rxjava.redux.state.Message
import me.dmba.trex.sample.rxjava.redux.state.MessageAction
import me.dmba.trex.sample.rxjava.redux.state.MessageAction.NewMessage
import javax.inject.Inject

/**
 *
 */
class MessagesReducer @Inject constructor() : Reducer<MessageAction, List<Message>> {

    override fun reduce(action: MessageAction, state: List<Message>): List<Message> = when (action) {

        is NewMessage -> state + action.message

    }

}
