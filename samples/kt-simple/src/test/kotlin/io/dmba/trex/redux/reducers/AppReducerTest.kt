package io.dmba.trex.redux.reducers

import io.dmba.trex.redux.state.CountAction
import io.dmba.trex.redux.state.FavAction
import me.dmba.trex.sample.store.reducers.FavReducer
import me.dmba.trex.sample.store.state.AppState
import me.dmba.trex.sample.store.state.CountState
import me.dmba.trex.sample.store.state.FavState
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Matchers.any
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppReducerTest {

    @Mock
    lateinit var appState: AppState

    @Mock
    lateinit var appStateFromCounter: AppState

    @Mock
    lateinit var appStateFromFav: AppState

    @Mock
    lateinit var countReducer: CountReducer

    @Mock
    lateinit var favReducer: FavReducer

    @InjectMocks
    lateinit var appReducer: AppReducer

    @Before
    fun beforeEach() {
        doReturn(appStateFromCounter).`when`(countReducer).reduce(any(CountAction::class.java), any(CountState::class.java))
        doReturn(appStateFromFav).`when`(favReducer).reduce(any(FavAction::class.java), any(FavState::class.java))
    }

    @Test
    fun `should call count reducer`() {
        // Given
        val action = CountAction.Add(0)

        // When
        val newState = appReducer.reduce(action, appState)

        // Then
        assertThat(newState).isSameAs(appStateFromCounter)
    }

    @Test
    fun `should call fav reducer`() {
        // Given
        val action = FavAction.MakeFav()

        // When
        val newState = appReducer.reduce(action, appState)

        // Then
        assertThat(newState).isSameAs(appStateFromFav)
    }

}
