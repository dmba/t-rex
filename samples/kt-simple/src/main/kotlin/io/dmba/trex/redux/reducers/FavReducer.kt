package me.dmba.trex.sample.store.reducers

import io.dmba.trex.redux.state.FavAction
import me.dmba.trex.Reducer
import me.dmba.trex.sample.store.state.FavState
import javax.inject.Inject

class FavReducer @Inject constructor() : Reducer<FavAction, FavState> {

    override fun reduce(action: FavAction, state: FavState): FavState = when (action) {

        is FavAction.MakeFav -> state.copy(
            isFav = action.isFav
        )

    }

}
