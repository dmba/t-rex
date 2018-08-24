package io.dmba.trex.util

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class ImmediateScheduler : Scheduler() {

    override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable = super.scheduleDirect(run, 0, unit)

    override fun createWorker(): Scheduler.Worker = ExecutorScheduler.ExecutorWorker(Executor { it.run() })

}
