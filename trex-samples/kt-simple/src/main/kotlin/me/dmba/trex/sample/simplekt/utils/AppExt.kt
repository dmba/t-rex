package me.dmba.trex.sample.simplekt.utils

import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer

/**
 *
 */
operator fun DisposableContainer.plusAssign(disposable: Disposable) {
    add(disposable)
}
