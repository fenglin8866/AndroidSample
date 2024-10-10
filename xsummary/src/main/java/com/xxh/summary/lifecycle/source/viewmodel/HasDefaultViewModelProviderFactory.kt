package com.xxh.summary.lifecycle.source.viewmodel

/**
 * Interface that marks a [ViewModelStoreOwner] as having a default
 * [ViewModelProvider.Factory] for use with [ViewModelProvider].
 *
 * 该接口将ViewModelStoreOwner标记为具有默认ViewModelProvider.Factory，用于ViewModelProvider
 */
interface HasDefaultViewModelProviderFactory {
    /**
     * Returns the default [ViewModelProvider.Factory] that should be
     * used when no custom `Factory` is provided to the
     * [ViewModelProvider] constructors.
     *
     *返回默认ViewModelProvider.Factory，当没有自定义的Factory供ViewModelProvider构造方法时
     *
     */
    val defaultViewModelProviderFactory: ViewModelProvider.Factory

    /**
     * Returns the default [CreationExtras] that should be passed into
     * [ViewModelProvider.Factory.create] when no overriding
     * [CreationExtras] were passed to the [ViewModelProvider] constructors.
     *
     * 返回默认的CreationExtras，当没有覆盖的CreationExtras传递给ViewModelProvider构造方法时，应该把该默认值传递给
     * ViewModelProvider.Factory.create
     */
    val defaultViewModelCreationExtras: CreationExtras
        get() = CreationExtras.Empty
}