package hooks

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow

fun <T, F> useFlowEmit(flow: F): Pair<T, Emit<T>> where F : StateFlow<T>, F : FlowCollector<T> {
    val value = useFlow(flow)
    val emit = useEmit(flow)

    return Pair(value, emit)
}