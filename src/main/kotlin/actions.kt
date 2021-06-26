import redux.RAction

data class AddTodo(val todoText: String): RAction
data class ToggleTodo(val todoId: Int): RAction

data class SetVisibilityFilter(val filter: VisibilityFilter): RAction
