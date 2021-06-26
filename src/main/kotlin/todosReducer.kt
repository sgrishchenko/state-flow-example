import redux.RAction

fun todosReducer(state: List<Todo> = emptyList(), action: RAction) =
    when (action) {
        is AddTodo -> state + Todo(text = action.todoText)
        is ToggleTodo -> state.map {
            if (it.id == action.todoId) {
                it.copy(completed = !it.completed)
            } else {
                it
            }
        }
        else -> state
    }
