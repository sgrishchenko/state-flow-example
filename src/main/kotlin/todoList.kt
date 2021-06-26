import react.child
import react.dom.ul
import react.functionalComponent
import react.memo
import react.redux.useSelector
import react.useMemo

val TodoList = memo(functionalComponent("TodoList") {
    val todos = useSelector{ state: State -> state.todos }
    val visibilityFilter = useSelector{ state: State -> state.visibilityFilter }

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
                    todoId = visibleTodo.id
                }
            }
        }
    }
})

