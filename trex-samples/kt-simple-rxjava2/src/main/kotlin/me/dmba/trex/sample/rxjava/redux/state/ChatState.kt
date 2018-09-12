package me.dmba.trex.sample.rxjava.redux.state

/**
 *
 */
data class ChatState(
    val users: List<User>,
    val messages: List<Message>
)

/**
 *
 */
data class User(
    val id: String,
    val name: String,
    val isLoggedIn: Boolean
)

/**
 *
 */
data class Message(
    val id: String,
    val userId: String,
    val text: String
)
