import kotlinx.browser.document
import kotlinx.browser.window
import react.child
import react.dom.render
import react.redux.provider
import redux.createStore
import redux.rEnhancer

fun main() {
    window.onload = {
        val store = createStore(rootReducer, State(), rEnhancer())

        render(document.getElementById("root")) {
            provider(store) {
                child(App)
            }
        }
    }
}
