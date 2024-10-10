package com.xxh.summary.lifecycle.source.savedstate

import android.os.Bundle
import com.xxh.summary.lifecycle.source.lifecycle.Lifecycle
import com.xxh.summary.lifecycle.source.lifecycle.LifecycleEventObserver
import com.xxh.summary.lifecycle.source.lifecycle.LifecycleOwner

internal class Recreator(
    private val owner: SavedStateRegistryOwner
) : LifecycleEventObserver {

    /**
     * 感知生命周期onCreate事件，执行后移除获取要还原的类，并执行onRecreated方法
     */
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event != Lifecycle.Event.ON_CREATE) {
            throw AssertionError("Next event must be ON_CREATE")
        }
        source.lifecycle.removeObserver(this)
        val bundle: Bundle = owner.savedStateRegistry
            .consumeRestoredStateForKey(COMPONENT_KEY) ?: return
        val classes: MutableList<String> = bundle.getStringArrayList(CLASSES_KEY)
            ?: throw IllegalStateException(
                "Bundle with restored state for the component " +
                        "\"$COMPONENT_KEY\" must contain list of strings by the key " +
                        "\"$CLASSES_KEY\""
            )
        for (className: String in classes) {
            reflectiveNew(className)
        }
    }

    /**
     * 通过类名创建SavedStateRegistry.AutoRecreated实例，并调用onRecreated方法
     */
    private fun reflectiveNew(className: String) {
        val clazz: Class<out SavedStateRegistry.AutoRecreated> =
            try {
                Class.forName(className, false, Recreator::class.java.classLoader)
                    .asSubclass(SavedStateRegistry.AutoRecreated::class.java)
            } catch (e: ClassNotFoundException) {
                throw RuntimeException("Class $className wasn't found", e)
            }
        val constructor =
            try {
                clazz.getDeclaredConstructor()
            } catch (e: NoSuchMethodException) {
                throw IllegalStateException(
                    "Class ${clazz.simpleName} must have " +
                            "default constructor in order to be automatically recreated", e
                )
            }
        constructor.isAccessible = true
        val newInstance: SavedStateRegistry.AutoRecreated =
            try {
                constructor.newInstance()
            } catch (e: Exception) {
                throw RuntimeException("Failed to instantiate $className", e)
            }
        newInstance.onRecreated(owner)
    }

    /**
     * SavedStateRegistry注册一个SavedStateProvider
     */
    internal class SavedStateProvider(registry: SavedStateRegistry) :
        SavedStateRegistry.SavedStateProvider {

        private val classes: MutableSet<String> = mutableSetOf()

        init {
            registry.registerSavedStateProvider(COMPONENT_KEY, this)
        }

        //保存要还原的类
        override fun saveState(): Bundle {
            return Bundle().apply {
                putStringArrayList(CLASSES_KEY, ArrayList(classes))
            }
        }

        //把要还原的类添加到SavedStateProvider中
        fun add(className: String) {
            classes.add(className)
        }
    }

    companion object {
        const val CLASSES_KEY = "classes_to_restore"
        const val COMPONENT_KEY = "androidx.savedstate.Restarter"
    }
}