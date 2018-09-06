package me.dmba.trex

import io.reactivex.Completable.fromAction
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import me.dmba.trex.internal.DefaultSchedulersProvider
import me.dmba.trex.internal.DispatchChainInitializerDelegate
import me.dmba.trex.internal.with

/**
 *
 */
open class Store<A, S> constructor(

    initialState: S,

    internal val reducer: Reducer<A, S>,

    internal vararg val middlewares: Middleware<A, S>,

    internal val schedulers: SchedulersProvider = DefaultSchedulersProvider()

) {

    /**
     *
     */
    internal val rootDispatcher: Next<A> by DispatchChainInitializerDelegate()

    /**
     *
     */
    internal val stateSubject: Subject<S> = BehaviorSubject.createDefault(initialState)

    /**
     *
     */
    val state: Observable<S> get() = stateSubject.with(schedulers)

    /**
     *
     */
    val first: S get() = state.blockingFirst()

    /**
     *
     */
    fun dispatch(action: A): Disposable = fromAction { rootDispatcher(action) }
        .onErrorComplete()
        .with(schedulers)
        .subscribe()

    /**
     *
     */
    fun subscribe(onNext: (state: S) -> Unit): Disposable = stateSubject
        .with(schedulers)
        .subscribe(onNext)

}
