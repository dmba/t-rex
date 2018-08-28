package me.dmba.trex.sample.simplekt.redux.state

/**
 *
 */
sealed class AppAction {
}

/**
 *
 */
sealed class FavAction : AppAction() {

    data class MakeFav(val isFav: Boolean = true) : FavAction()

}

/**
 *
 */
sealed class CountAction : AppAction() {

    data class Add(val value: Int) : CountAction()

    data class Sub(val value: Int) : CountAction()

}

/**
 *
 */
sealed class ApiAction : AppAction() {

    class ProduceError : ApiAction()

}
