package com.xxh.summary.lifecycle.source.lifecycle

internal class CompositeGeneratedAdaptersObserver(
    private val generatedAdapters: Array<GeneratedAdapter>
) :
    LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val logger = MethodCallsLogger()
        for (adapter in generatedAdapters) {
            adapter.callMethods(source, event, false, logger)
        }
        for (adapter in generatedAdapters) {
            adapter.callMethods(source, event, true, logger)
        }
    }
}