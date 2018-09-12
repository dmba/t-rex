package me.dmba.trex.sample.rxjava

import me.dmba.trex.sample.rxjava.di.ChatComponent
import me.dmba.trex.sample.rxjava.di.DaggerChatComponent
import me.dmba.trex.sample.rxjava.redux.state.ChatState
import me.dmba.trex.sample.rxjava.utils.newUser

/**
 *
 */
fun main(args: Array<String>) {
    DaggerChatComponent
        .create()
        .apply(::run)
}

/**
 *
 */
fun run(component: ChatComponent): Unit = with(component) {
    store.subscribe(::renderView)

    val kenan = newUser("Kenan")
    val kel = newUser("Kel")

    actionCreator.apply {

        login(kenan)

        login(kel)

        sendMessage(kenan, "Who loves orange soda?")

        sendMessage(kel, "K-K-Kel loves orange soda.")

        sendMessage(kenan, "Is it true? Is it TRUUUUE?")

        sendMessage(kel, "MMMHHMMM! I do, I do, I do-oooh!")

        logout(kel)

        logout(kenan)
    }

    readLine()
}

/**
 *
 */
fun renderView(state: ChatState) = println("#chat: $state")
