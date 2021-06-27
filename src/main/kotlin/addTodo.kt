import hooks.useEmit
import kotlinx.html.ButtonType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import react.dom.*
import react.functionalComponent
import react.memo
import react.useContext
import react.useRef

val AddTodo = memo(functionalComponent("AddTodo") {
    val flow = useContext(StateContext)
    val emit = useEmit(flow)
    val input = useRef<HTMLInputElement>()

    div {
        form {
            attrs {
                onSubmitFunction = { event ->
                    event.preventDefault()

                    val value = input.current?.value

                    if (!value.isNullOrBlank()) {
                        emit {
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