package me.dmba.trex.internal

import me.dmba.trex.Middleware
import me.dmba.trex.Next
import me.dmba.trex.Store
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 *
 */
internal class DispatchChainInitializerDelegate<A, S> : ReadOnlyProperty<Store<A, S>, Next<A>> {

    /**
     *
     */
    override operator fun getValue(thisRef: Store<A, S>, property: KProperty<*>): Next<A> = with(thisRef) {
        return middlewares
            .reversed()
            .fold(provideReducerDispatcher(this), provideMiddlewareDispatcher(this))
    }

    /**
     *
     */
    internal fun provideReducerDispatcher(store: Store<A, S>): Next<A> = with(store) {
        return { action -> reducer.reduce(action, lastState).also(stateSubject::onNext) }
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
