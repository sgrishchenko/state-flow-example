import react.child
import react.dom.div
import react.functionalComponent
import react.memo

val App = memo(functionalComponent("App") {

    div {
        child(TodoForm)
        child(TodoList)
        child(Footer)
    }
})