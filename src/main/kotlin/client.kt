import kotlinx.browser.document
import kotlinx.browser.window
//import pitfalls.DontUseClosure
import react.child
import react.dom.render

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            child(App)
//            child(DontUseClosure)
        }
    }
}
