import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.attrs
import react.dom.button
import react.dom.jsStyle
import react.functionalComponent
import react.memo
import react.redux.useDispatch
import react.redux.useSelector
import redux.RAction

external interface FilterLinkProps : RProps {
    var filter: VisibilityFilter
}

val FilterLink = memo(functionalComponent<FilterLinkProps>("FilterLink") { props ->
    val visibilityFilter = useSelector { state: State -> state.visibilityFilter }
    val dispatch = useDispatch<RAction, Unit>()

    val active = props.filter === visibilityFilter

    button {
        attrs {
            disabled = active
            jsStyle {
                marginLeft = "4px"
            }
            onClickFunction = {
                dispatch(SetVisibilityFilter(props.filter))
            }
        }

        props.children()
    }
})
