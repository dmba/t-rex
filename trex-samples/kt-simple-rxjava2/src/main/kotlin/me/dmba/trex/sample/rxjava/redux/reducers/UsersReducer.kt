package me.dmba.trex.sample.rxjava.redux.reducers

import me.dmba.trex.Reducer
import me.dmba.trex.sample.rxjava.redux.state.User
import me.dmba.trex.sample.rxjava.redux.state.UserAction
import me.dmba.trex.sample.rxjava.redux.state.UserAction.Login
import me.dmba.trex.sample.rxjava.redux.state.UserAction.Logout
import javax.inject.Inject

/**
 *
 */
class UsersReducer @Inject constructor() : Reducer<UserAction, List<User>> {

    override fun reduce(action: UserAction, state: List<User>): List<User> = when (action) {

        is Login -> state + action.user.copy(
            isLoggedIn = true
        )

        is Logout -> state - action.user

    }

}
