package me.dmba.trex.helpers

import io.reactivex.schedulers.TestScheduler
import me.dmba.trex.SchedulersProvider

class TestSchedulersProvider : SchedulersProvider {

    override val ui = TestScheduler()

    override val background = TestScheduler()

}
