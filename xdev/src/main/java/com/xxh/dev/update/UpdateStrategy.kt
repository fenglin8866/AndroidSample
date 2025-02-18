package com.xxh.dev.update

class UpdateStrategy(
    private val storage: UpdateSharedPrefStorage,
    private val locateUpdateConfig: LocateUpdateConfig = LocateUpdateConfig(),
    private val remoteUpdateConfig: RemoteUpdateConfig = RemoteUpdateConfig(),
) {

    fun isNeedUpdate(): Boolean {
        return remoteUpdateConfig.flexibleInterval > 0 || remoteUpdateConfig.immediateInterval > 0
    }

    fun getUpdatePriority(): Int {
        return remoteUpdateConfig.updatePriority
    }

    fun getUpdateType(versionStalenessDays: Int?): UpdateType? {
        var type: UpdateType? = null

        versionStalenessDays?.let {
            if (remoteUpdateConfig.flexibleInterval > 0 && remoteUpdateConfig.immediateInterval == 0) {
                if (it > remoteUpdateConfig.flexibleInterval) {
                    type = UpdateType.FLEXIBLE
                }
            } else if (remoteUpdateConfig.flexibleInterval == 0 && remoteUpdateConfig.immediateInterval > 0) {
                if (it > remoteUpdateConfig.immediateInterval) {
                    type = UpdateType.IMMEDIATE
                }
            } else if (remoteUpdateConfig.flexibleInterval > 0 && remoteUpdateConfig.immediateInterval > 0) {
                if (remoteUpdateConfig.immediateInterval > remoteUpdateConfig.flexibleInterval) {
                    if (it > remoteUpdateConfig.flexibleInterval &&
                        it < remoteUpdateConfig.immediateInterval
                    ) {
                        type = UpdateType.FLEXIBLE
                    } else if (it >= remoteUpdateConfig.immediateInterval) {
                        type = UpdateType.IMMEDIATE
                    }
                } else {
                    if (it > remoteUpdateConfig.flexibleInterval) {
                        type = UpdateType.FLEXIBLE
                    }
                }
            }
        }

        return type
    }

    fun isCheckUpdate(): Boolean {
        return locateUpdateConfig.isCheckUpdate
    }

    fun isCheckInstall(): Boolean {
        return locateUpdateConfig.isCheckInstall
    }

    fun isKeepImmediateUpdate(): Boolean {
        return locateUpdateConfig.isKeepImmediateUpdate
    }

    fun showUpdateOfHome(versionCode: Int): Boolean {
        val info = storage.getString("")
        var versionCodeLast = 0
        var hintTimeLast = 0L
        if (info.isNotEmpty()) {
            val (versionCodeStr, lastHintTimeStr) = info.split("|")
            versionCodeLast = versionCodeStr.toInt()
            hintTimeLast = lastHintTimeStr.toLong()
        }
        val timeout = System.currentTimeMillis() - hintTimeLast > remoteUpdateConfig.flexibleFre
        val hasNew = versionCodeLast != versionCode
        val show = timeout || hasNew
        if (show) {
            savaVersionUpdateInfo("${versionCode}|${System.currentTimeMillis()}")
        }
        return show
    }

    private fun savaVersionUpdateInfo(info:String){
        storage.setString("",info)
    }

}