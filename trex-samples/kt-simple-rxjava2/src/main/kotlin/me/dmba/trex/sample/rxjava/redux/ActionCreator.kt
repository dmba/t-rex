package me.dmba.trex.sample.rxjava.redux

import me.dmba.trex.sample.rxjava.redux.state.MessageAction
import me.dmba.trex.sample.rxjava.redux.state.User
import me.dmba.trex.sample.rxjava.redux.state.UserAction
import me.dmba.trex.sample.rxjava.utils.newMessage
import javax.inject.Inject

class ActionCreator @Inject constructor(val store: ChatStore) {

    fun login(user: User) = store.dispatch(UserAction.Login(user))

    fun logout(user: User) = store.dispatch(UserAction.Logout(user))

    fun sendMessage(user: User, msg: String) = store.dispatch(MessageAction.NewMessage(newMessage(user, msg)))

}
