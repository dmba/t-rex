package me.dmba.trex

import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

open class Store<A, S> constructor(

    private val schedulers: TReXSchedulers,

    initialState: S,

    internal val reducer: Reducer<A, S>,

    vararg middlewares: Middleware<A, S>

) {
    val state: S get() = stateSubject.blockingFirst()

    val stateSubject: Subject<S> = BehaviorSubject.createDefault(initialState)

    private val rootDispatcher: Next<A> by DispatchChainInitializerDelegate(middlewares)

    fun dispatch(action: A) = Completable.fromAction { rootDispatcher(action) }
        .with(schedulers)
        .onErrorComplete()
        .subscribe()

    fun subscribe(onNext: (state: S) -> Unit,
                  onError: (error: Throwable) -> Unit = {}): Disposable = stateSubject
        .with(schedulers)
        .subscribe(onNext, onError)

}
