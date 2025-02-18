package com.xxh.dev.update

data class RemoteUpdateConfig(
    val updatePriority: Int = 0,
    val flexibleInterval: Int = 30,
    val immediateInterval: Int = 0,
    val flexibleFre: Int = 7//主页七天内同一个更新版本只提示一次灵活更新
)

data class LocateUpdateConfig(
    val isCheckUpdate: Boolean = false,
    val isCheckInstall: Boolean = false,
    val isKeepImmediateUpdate: Boolean = false
)

enum class UpdateType {
    FLEXIBLE, IMMEDIATE
}