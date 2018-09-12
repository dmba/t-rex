package me.dmba.trex

import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject.create
import io.reactivex.subjects.Subject

/**
 *
 */
open class RxStore<A, S> constructor(

    private val schedulers: SchedulersProvider,

    initialState: S,

    reducer: Reducer<A, S>,

    vararg middlewares: Middleware<A, S>

) : Store<A, S>(initialState, reducer, *middlewares) {

    /**
     *
     */
    internal val stateSubject: Subject<S>
        get() = create<S>().also { super.subscribe(it::onNext) }

    /**
     *
     */
    val stream: Flowable<S>
        get() = stateSubject.hide()
            .with(schedulers)
            .toFlowable(BackpressureStrategy.LATEST)

    /**
     *
     */
    override fun dispatch(action: A) {
        Completable.fromAction { super.dispatch(action) }
            .with(schedulers)
            .subscribe()
    }

    /**
     *
     */
    override fun subscribe(onNext: Next<S>): Unsubscribe {
        val disposable = stream.subscribe(onNext)
        return { disposable.dispose() }
    }

}
