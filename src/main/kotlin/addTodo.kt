import kotlinx.html.ButtonType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*

val AddTodo = memo(functionalComponent("AddTodo") {
    val setState = useContext(StateSetterContext)
    val input = useRef<HTMLInputElement>()

    div {
        form {
            attrs {
                onSubmitFunction = { event ->
                    event.preventDefault()

                    val value = input.current?.value

                    if (!value.isNullOrBlank()) {
                        setState {
                            it.copy(todos = it.todos + Todo(text = value))
                        }
                        input.current?.value = ""
                    }

                }
            }

            input {
                ref = input
            }

            button {
                attrs {
                    type = ButtonType.submit
                }

                +"Add Todo"
            }
        }
    }
})