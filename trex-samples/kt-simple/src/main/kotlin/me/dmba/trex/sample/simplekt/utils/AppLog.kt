package me.dmba.trex.sample.simplekt.utils

import javax.inject.Inject

class AppLog @Inject constructor() {

    private val tag: String = "APP"

    fun before(msg: String) = println("$tag: before >> $msg")

    fun after(msg: String) = println("$tag: after  << $msg")

}
