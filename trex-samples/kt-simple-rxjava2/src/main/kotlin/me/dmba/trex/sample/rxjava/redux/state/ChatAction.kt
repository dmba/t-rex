package me.dmba.trex.sample.rxjava.redux.state

/**
 *
 */
sealed class ChatAction {
}

/**
 *
 */
sealed class UserAction : ChatAction() {

    data class Login(val user: User) : UserAction()

    data class Logout(val user: User) : UserAction()

}

/**
 *
 */
sealed class MessageAction : ChatAction() {

    data class NewMessage(val message: Message) : MessageAction()

}
