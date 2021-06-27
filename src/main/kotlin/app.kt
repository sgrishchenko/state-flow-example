import kotlinx.coroutines.flow.MutableStateFlow
import react.*
import react.dom.div

val App = memo(functionalComponent("App") {

    val state by useState { MutableStateFlow(State()) }

    StateContext.Provider {
        attrs {
            value = state
        }

        div {
            child(AddTodo)
            child(TodoList)
            child(Footer)
        }
    }
})