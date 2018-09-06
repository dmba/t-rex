package me.dmba.trex.internal

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers.trampoline
import me.dmba.trex.SchedulersProvider

/**
 *
 */
internal class DefaultSchedulersProvider : SchedulersProvider {

    /**
     *
     */
    override val ui: Scheduler = trampoline()

    /**
     *
     */
    override val background: Scheduler = trampoline()

}
