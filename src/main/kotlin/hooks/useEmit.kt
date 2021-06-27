package hooks

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import react.useMemo

interface Emit<T> {
    operator fun invoke(value: T)
    operator fun invoke(updater: (T) -> T)
}

fun <T, F> useEmit(flow: F): Emit<T> where F : StateFlow<T>, F : FlowCollector<T> {
    val coroutineScope = useCoroutineScope()

    return useMemo(flow, coroutineScope) {
        object : Emit<T> {
            override fun invoke(value: T) {
                coroutineScope.launch {
                    flow.emit(value)
                }
            }

            override fun invoke(updater: (T) -> T) {
                coroutineScope.launch {
                    flow.emit(updater(flow.value))
                }
            }
        }
    }
}