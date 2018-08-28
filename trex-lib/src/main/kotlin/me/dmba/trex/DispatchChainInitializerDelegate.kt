package me.dmba.trex

import kotlin.reflect.KProperty

/**
 *
 */
internal class DispatchChainInitializerDelegate<A, S> {

    /**
     *
     */
    operator fun getValue(store: Store<A, S>, property: KProperty<*>): (A) -> Unit {
        return store.middlewares
            .reversed()
            .fold(provideReducerDispatcher(store), provideMiddlewareDispatcher(store))
    }

    /**
     *
     */
    internal fun provideReducerDispatcher(store: Store<A, S>): Next<A> {
        return { action -> store.reducer.reduce(action, store.state).also(store.stateSubject::onNext) }
    }

    /**
     *
     */
    internal fun provideMiddlewareDispatcher(store: Store<A, S>): (Next<A>, Middleware<A, S>) -> Next<A> {
        return { next, middleware -> provideActionDispatcher(store, next, middleware) }
    }

    /**
     *
     */
    internal fun provideActionDispatcher(store: Store<A, S>, next: Next<A>, middleware: Middleware<A, S>): Next<A> {
        return { action -> middleware.dispatch(action, store, next) }
    }

}
