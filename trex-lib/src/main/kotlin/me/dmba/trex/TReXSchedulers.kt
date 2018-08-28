package me.dmba.trex

import io.reactivex.Scheduler

/**
 *
 */
open class TReXSchedulers(
    /**
     *
     */
    val main: Scheduler,
    /**
     *
     */
    val back: Scheduler
)
