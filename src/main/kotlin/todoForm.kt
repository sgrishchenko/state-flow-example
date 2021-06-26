import kotlinx.html.ButtonType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import react.dom.*
import react.functionalComponent
import react.memo
import react.redux.useDispatch
import react.useRef
import redux.RAction

val TodoForm = memo(functionalComponent("TodoForm") {
    val dispatch = useDispatch<RAction, Unit>()
    val input = useRef<HTMLInputElement>()

    div {
        form {
            attrs {
                onSubmitFunction = { event ->
                    event.preventDefault()

                    val value = input.current?.value

                    if (!value.isNullOrBlank()) {
                        dispatch(AddTodo(value))
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