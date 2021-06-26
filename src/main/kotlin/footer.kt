import react.child
import react.dom.div
import react.dom.span
import react.functionalComponent
import react.memo

val Footer = memo(functionalComponent("Footer") {
    div {
        span { +"Show: " }
        child(FilterLink) {
            attrs { filter = VisibilityFilter.SHOW_ALL }
            +"All"
        }
        child(FilterLink) {
            attrs { filter = VisibilityFilter.SHOW_ACTIVE }
            +"Active"
        }
        child(FilterLink) {
            attrs { filter = VisibilityFilter.SHOW_COMPLETED }
            +"Completed"
        }
    }
})