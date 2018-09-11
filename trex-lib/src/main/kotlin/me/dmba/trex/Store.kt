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
        val reducerDispatcher: Next<A> = { state = reducer.reduce(it, state) }

        return@lazy middlewares.foldRight(reducerDispatcher) { middleware, next ->
            { middleware.dispatch(it, this, next) }
        }
    }

    /**
     *
     */
    var state: S = initialState
        internal set(newState) {
            field = newState
        }

    /**
     *
     */
    fun dispatch(action: A) = next(action)

    /**
     *
     */
    fun subscribe(onNext: Next<S>): Unsubscribe = {
        subscribers -= onNext
    }.also {
        subscribers += onNext
    }

}
