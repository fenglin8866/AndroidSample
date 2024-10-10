package com.xxh.summary.lifecycle.source.savedstate


import android.os.Bundle
import androidx.annotation.MainThread
import com.xxh.summary.lifecycle.source.lifecycle.Lifecycle

/**
 * An API for [SavedStateRegistryOwner] implementations to control [SavedStateRegistry].
 *
 * `SavedStateRegistryOwner` should call [performRestore] to restore state of
 * [SavedStateRegistry] and [performSave] to gather SavedState from it.
 *
 * 用于 [SavedStateRegistryOwner] 实现以控制 [SavedStateRegistry] 的 API
 * “SavedStateRegistryOwner”应该调用[performRestore]来恢复[SavedStateRegistry]的状态，[performSave]从中收集SavedState。
 */
class SavedStateRegistryController private constructor(private val owner: SavedStateRegistryOwner) {

    /**
     * The [SavedStateRegistry] owned by this controller
     */
    val savedStateRegistry: SavedStateRegistry = SavedStateRegistry()

    private var attached = false

    /**
     * Perform the initial, one time attachment necessary to configure this
     * [SavedStateRegistry]. This must be called when the owner's [Lifecycle] is
     * [Lifecycle.State.INITIALIZED] and before you call [performRestore].
     * 执行配置此 [SavedStateRegistry] 所需的初始一次性附件
     * 当所有者的 [生命周期] 为 [Lifecycle.State.INITIALIZED] 时和调用 [performRestore] 之前，必须调用此选项
     */
    @MainThread
    fun performAttach() {
        val lifecycle = owner.lifecycle
        check(lifecycle.currentState == Lifecycle.State.INITIALIZED) {
            ("Restarter must be created only during owner's initialization stage")
        }
        lifecycle.addObserver(Recreator(owner))
        savedStateRegistry.performAttach(lifecycle)
        attached = true
    }

    /**
     * An interface for an owner of this [SavedStateRegistry] to restore saved state.
     *
     * @param savedState restored state
     * 恢复保持状态
     *
     */
    @MainThread
    fun performRestore(savedState: Bundle?) {
        // To support backward compatibility with libraries that do not explicitly
        // call performAttach(), we make sure that work is done here
        if (!attached) {
            performAttach()
        }
        val lifecycle = owner.lifecycle
        check(!lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            ("performRestore cannot be called when owner is ${lifecycle.currentState}")
        }
        savedStateRegistry.performRestore(savedState)
    }

    /**
     * An interface for an owner of this  [SavedStateRegistry]
     * to perform state saving, it will call all registered providers and
     * merge with unconsumed state.
     *
     * @param outBundle Bundle in which to place a saved state
     *
     * 此 [SavedStateRegistry] 的所有者执行状态保存的接口，它将调用所有已注册的提供程序并与未使用的状态合并。
     */
    @MainThread
    fun performSave(outBundle: Bundle) {
        savedStateRegistry.performSave(outBundle)
    }

    companion object {
        /**
         * Creates a [SavedStateRegistryController].
         *
         * It should be called during construction time of [SavedStateRegistryOwner]
         */
        @JvmStatic
        fun create(owner: SavedStateRegistryOwner): SavedStateRegistryController {
            return SavedStateRegistryController(owner)
        }
    }
}
