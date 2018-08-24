package me.dmba.trex

interface Middleware<A, S> {

    fun dispatch(action: A, store: Store<A, S>, next: Next<A> = {})

}
