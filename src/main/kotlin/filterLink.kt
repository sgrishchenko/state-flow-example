import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.attrs
import react.dom.button
import react.dom.jsStyle
import react.functionalComponent
import react.memo
import react.useContext

external interface FilterLinkProps : RProps {
    var filter: VisibilityFilter
}

val FilterLink = memo(functionalComponent<FilterLinkProps>("FilterLink") { props ->
    val state = useContext(StateContext)
    val setState = useContext(StateSetterContext)

    val active = props.filter === state.visibilityFilter

    button {
        attrs {
            disabled = active
            jsStyle {
                marginLeft = "4px"
            }
            onClickFunction = {
                setState {
                    it.copy(visibilityFilter = props.filter)
                }
            }
        }

        props.children()
    }
})
