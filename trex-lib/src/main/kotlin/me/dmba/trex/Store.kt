package me.dmba.trex

/**
 *
 */
open class Store<A, S> constructor(

    initialState: S,

    internal val reducer: Reducer<A, S>,

    internal vararg val middlewares: Middleware<A, S>

) {

    /**
     *
     */
    internal val subscribers: MutableList<Next<S>> = mutableListOf()

    /**
     *
     */
    internal val next: Next<A> by lazy {
        val lastDispatcher: Next<A> = {
            state = reducer.reduce(it, state)
            subscribers.forEach { it(state) }
        }

        return@lazy middlewares.foldRight(lastDispatcher) { middleware, next ->
            { middleware.dispatch(it, this, next) }
        }
    }

    /**
     *
     */
    open var state: S = initialState
        internal set(newState) {
            field = newState
        }

    /**
     *
     */
    open fun dispatch(action: A) = next(action)

    /**
     *
     */
    open fun subscribe(onNext: Next<S>): Unsubscribe {
        subscribers += onNext
        onNext(state)
        return { subscribers -= onNext }
    }

}
