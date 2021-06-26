import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.attrs
import react.dom.jsStyle
import react.dom.li
import react.functionalComponent
import react.memo
import react.useContext

external interface TodoItemProps : RProps {
    var todo: Todo
}

val TodoItem = memo(functionalComponent<TodoItemProps>("TodoItem") { props ->
    val (_, setState) = useContext(StateContext)

    li {
        attrs {
            jsStyle {
                textDecoration = if (props.todo.completed) "line-through" else "none"
            }
            onClickFunction = {
                setState {
                    it.copy(
                        todos = it.todos.map { todo ->
                            if (todo == props.todo) {
                                todo.copy(
                                    completed = !todo.completed
                                )
                            } else {
                                todo
                            }
                        }
                    )
                }
            }
        }

        +props.todo.text
    }
})