import redux.RAction

fun visibilityFilterReducer(state: VisibilityFilter = VisibilityFilter.SHOW_ALL, action: RAction) =
    when (action) {
        is SetVisibilityFilter -> action.filter
        else -> state
    }