package me.dmba.trex

import io.reactivex.Completable
import io.reactivex.Observable

/**
 *
 */
internal fun <T> Observable<T>.with(schedulers: SchedulersProvider): Observable<T> = subscribeOn(schedulers.background).observeOn(schedulers.ui)

/**
 *
 */
internal fun Completable.with(schedulers: SchedulersProvider): Completable = subscribeOn(schedulers.background).observeOn(schedulers.ui)
