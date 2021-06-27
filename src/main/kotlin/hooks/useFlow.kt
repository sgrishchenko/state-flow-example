package hooks

import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import react.useEffect
import react.useState

fun <T> useFlow(flow: StateFlow<T>): T {
    val coroutineScope = useCoroutineScope()
    val (state, setState) = useState(flow.value)

    useEffect(flow, coroutineScope) {
        coroutineScope.launch {
            flow.collect {
                setState(it)
            }
        }
    }

    return state
}