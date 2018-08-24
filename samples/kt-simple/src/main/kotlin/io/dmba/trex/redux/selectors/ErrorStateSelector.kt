package io.dmba.trex.redux.selectors

import io.dmba.trex.redux.AppStore
import io.reactivex.Observable
import io.reactivex.Single
import me.dmba.trex.sample.store.state.ErrorState
import javax.inject.Inject

class ErrorStateSelector @Inject constructor(

    private val store: AppStore

) {

    val errorState: Observable<ErrorState>
        get() = store
            .stateSubject
            .map { it.errorState }
            .replay(1)

    val lastThreeErrors: Single<List<Throwable>>
        get() = errorState
            .flatMap { Observable.fromIterable(it.errors) }
            .take(3)
            .toList()
            .cache()

}
