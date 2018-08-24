package me.dmba.trex

import io.reactivex.Completable
import io.reactivex.Observable

internal fun <T> Observable<T>.with(schedulers: TReXSchedulers): Observable<T> = subscribeOn(schedulers.back).observeOn(schedulers.main)

internal fun Completable.with(schedulers: TReXSchedulers): Completable = subscribeOn(schedulers.back).observeOn(schedulers.main)

