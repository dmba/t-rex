package me.dmba.trex
import io.reactivex.Scheduler

/**
 *
 */
interface SchedulersProvider {

    /**
     *
     */
    val ui: Scheduler

    /**
     *
     */
    val background: Scheduler

}
