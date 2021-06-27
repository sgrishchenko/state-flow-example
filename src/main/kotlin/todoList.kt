import hooks.useFlow
import react.*
import react.dom.ul

val TodoList = memo(functionalComponent("TodoList") {
    val flow = useContext(StateContext)
    val state = useFlow(flow)
    val todos = state.todos
    val visibilityFilter = state.visibilityFilter

    val visibleTodos = useMemo(todos, visibilityFilter) {
        when (visibilityFilter) {
            VisibilityFilter.SHOW_ALL -> todos
            VisibilityFilter.SHOW_COMPLETED -> todos.filter { it.completed }
            VisibilityFilter.SHOW_ACTIVE -> todos.filter { !it.completed }
        }
    }

    ul {
        visibleTodos.forEachIndexed { index, visibleTodo ->
            child(TodoItem) {
                key = index.toString()
                attrs {
                    todo = visibleTodo
                }
            }
        }
    }
})

