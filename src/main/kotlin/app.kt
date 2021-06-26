import react.*
import react.dom.div

val App = memo(functionalComponent("App") {

    val (state, setState) = useState(State())

    StateContext.Provider {
        attrs {
            value = Pair(state, setState::invoke)
        }

        div {
            child(AddTodo)
            child(TodoList)
            child(Footer)
        }
    }
})