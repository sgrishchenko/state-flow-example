import redux.RAction
import redux.combineReducers

val rootReducer = combineReducers<Any, RAction>(mapOf(
    "todos" to ::todosReducer,
    "visibilityFilter" to ::visibilityFilterReducer,
))