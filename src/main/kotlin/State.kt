import kotlin.random.Random

data class Todo(
    val id: Int = Random.nextInt(),
    val text: String,
    val completed: Boolean = false,
)

enum class VisibilityFilter {
    SHOW_ALL,
    SHOW_COMPLETED,
    SHOW_ACTIVE,
}

data class State(
    val todos: List<Todo> = emptyList(),
    val visibilityFilter: VisibilityFilter = VisibilityFilter.SHOW_ALL
)
