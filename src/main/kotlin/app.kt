import react.*
import react.dom.div

val App = memo(functionalComponent("App") {

    val (state, setState) = useState(State())

    val stateSetter = useCallback<StateSetter>(setState) { setState(it) }

    StateSetterContext.Provider {
        attrs {
            value = stateSetter
        }

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
    }
})