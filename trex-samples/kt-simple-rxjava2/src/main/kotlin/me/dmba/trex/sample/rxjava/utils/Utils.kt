package me.dmba.trex.sample.rxjava.utils

import me.dmba.trex.sample.rxjava.redux.state.Message
import me.dmba.trex.sample.rxjava.redux.state.User
import java.util.*


/**
 *
 */
fun newUuid(): String = UUID.randomUUID().toString()

/**
 *
 */
fun newUser(name: String, isLoggedIn: Boolean = false): User = User(newUuid(), name, isLoggedIn)

/**
 *
 */
fun newMessage(user: User, msg: String, isLoggedIn: Boolean = false): Message = Message(newUuid(), user.id, msg)
