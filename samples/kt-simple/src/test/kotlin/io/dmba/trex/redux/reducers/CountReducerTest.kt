package io.dmba.trex.redux.reducers

import io.dmba.trex.redux.state.CountAction.Add
import io.dmba.trex.redux.state.CountAction.Sub
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import me.dmba.trex.sample.store.state.CountState

class CountReducerTest : StringSpec({

    val state = CountState(
        value = 0
    )

    val reducer = CountReducer()

    "test add and sub" {
        forall(
            row(Add(3), state, 3),
            row(Add(-3), state, -3),
            row(Sub(3), state, -3),
            row(Sub(-3), state, 3)
        ) { action, state, expectedValue ->
            val newState: CountState = reducer.reduce(action, state)

            newState.value shouldBe expectedValue
        }
    }

})
