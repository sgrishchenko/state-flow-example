import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.attrs
import react.dom.jsStyle
import react.dom.li
import react.functionalComponent
import react.memo
import react.redux.useDispatch
import react.redux.useSelector
import redux.RAction

external interface TodoItemProps : RProps {
    var todoId: Int
}

val TodoItem = memo(functionalComponent<TodoItemProps>("TodoItem") { props ->
    val todo = useSelector{state: State -> state.todos.find { it.id == props.todoId } }
    val dispatch = useDispatch<RAction, Unit>()

    if (todo == null) return@functionalComponent

    li {
        attrs {
            jsStyle {
                textDecoration = if (todo.completed) "line-through" else "none"
            }
            onClickFunction = {
                dispatch(ToggleTodo(todo.id))
            }
        }

        +todo.text
    }
})