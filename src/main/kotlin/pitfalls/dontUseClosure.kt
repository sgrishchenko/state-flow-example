package pitfalls

import hooks.useCoroutineScope
import hooks.useFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import react.*
import react.dom.div

suspend fun getLeftFromServer(): String {
    println("Left request is started")
    delay(1000)
    println("Left request is finished")
    return "Left from Server"
}

suspend fun getRightFromServer(): String {
    println("Right request is started")
    delay(1000)
    println("Right request is finished")
    return "Right from Server"
}

val DontUseClosure = memo(functionalComponent {
    val flow by useState { MutableStateFlow(Pair("Left", "Right")) }
    val state = useFlow(flow)

    val coroutineScope = useCoroutineScope()

    useEffect(flow, coroutineScope) {
        coroutineScope.launch {
            val leftFromServer = getLeftFromServer()
            // Incorrect
            flow.emit(state.copy(first = leftFromServer))
            // Correct
//            flow.emit(flow.value.copy(first = leftFromServer))

            val rightFromServer = getRightFromServer()
            // Incorrect
            flow.emit(state.copy(second = rightFromServer))
            // Correct
//            flow.emit(flow.value.copy(second = rightFromServer))
        }
    }

    div {
        +state.toString()
    }
})