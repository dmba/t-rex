package me.dmba.trex

interface Reducer<A, S> {
    fun reduce(action: A, state: S): S
}
