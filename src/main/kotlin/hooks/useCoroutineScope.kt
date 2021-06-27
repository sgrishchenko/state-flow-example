package hooks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import react.useEffect
import react.useState

fun useCoroutineScope(): CoroutineScope {
    val job by useState { Job() }
    val scope by useState { CoroutineScope(job) }

    useEffect(job) {
        cleanup {
            job.cancel()
        }
    }

    return scope
}