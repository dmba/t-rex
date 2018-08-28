package me.dmba.trex

import io.reactivex.Scheduler

/**
 *
 */
class TReXSchedulers(
    /**
     *
     */
    val main: Scheduler,
    /**
     *
     */
    val back: Scheduler
)
