package com.xxh.dev.update

import android.app.Activity.RESULT_OK
import android.content.Context
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.InstallState
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.xxh.dev.R
import com.xxh.dev.lifecyclelib.lifecycle.DefaultLifecycleObserver
import com.xxh.dev.lifecyclelib.lifecycle.LifecycleOwner

/**
 * 为什么不将升级逻辑封装在ViewModel中?
 * 1、升级逻辑需要依赖Activity，而ViewModel不能依赖activity，因为ViewModel生命周期比activity长，如果依赖会出现内存泄漏。
 * 2、升级逻辑需要依赖Activity的回调函数。使用DefaultLifecycleObserver更合适。
 *
 * ================================
 * 推荐使用一个主Activity多个Fragment的架构，升级绑定在主Activity。
 * 目前是使主页和版本页面检查更新共用一个逻辑。而不是在两个activity中分别处理。
 *
 */
class AppUpdateHelper(
    private val activity: AppCompatActivity,
    private val strategy: UpdateStrategy
) : DefaultLifecycleObserver, InstallStateUpdatedListener {

    private var appUpdateManager: AppUpdateManager? = null

    private val activityResultLauncher: ActivityResultLauncher<IntentSenderRequest> =
        activity.registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result: ActivityResult ->
            // handle callback
            if (result.resultCode != RESULT_OK) {
                //log("Update flow failed! Result code: " + result.resultCode);
                // If the update is canceled or fails,
                // you can request to start the update again.
            }
        }

    override fun onStateUpdate(state: InstallState) {
        // Log state or install the update.
        when (state.installStatus()) {
            // (Optional) Provide a download progress bar.
            InstallStatus.DOWNLOADING -> {
                val bytesDownloaded = state.bytesDownloaded()
                val totalBytesToDownload = state.totalBytesToDownload()
                // Show update progress bar.
            }

            InstallStatus.DOWNLOADED -> {
                // After the update is downloaded, show a notification
                // and request user confirmation to restart the app.
                popupSnackbarForCompleteUpdate()
            }

            else -> {

            }

        }
    }

    // Displays the snackbar notification and call to action.
    private fun popupSnackbarForCompleteUpdate() {
        /**
         * 如果是多个activity，依赖的布局需要协定同一个id或参数传入。
         */
        Snackbar.make(
            activity.findViewById(R.id.activity_main_layout),
            "An update has just been downloaded.",
            Snackbar.LENGTH_INDEFINITE
        ).apply {
            setAction("RESTART") { appUpdateManager?.completeUpdate() }
            setActionTextColor(activity.resources.getColor(R.color.snackbar_action_text_color))
            show()
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        appUpdateManager = AppUpdateManagerFactory.create(activity)
        appUpdateManager?.registerListener(this)
        if (strategy.isCheckUpdate()) {
            checkUpdate()
        }
    }

    /**
     *
     */
    fun checkUpdate(showUpdate: Boolean = false) {
        if (strategy.isNeedUpdate()) {
            // Returns an intent object that you use to check for an update.
            val appUpdateInfoTask = appUpdateManager?.appUpdateInfo

            // Checks whether the platform allows the specified type of update,
            // and current version staleness.
            appUpdateInfoTask?.addOnSuccessListener { appUpdateInfo ->
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE /* 有可用更新 */
                    && appUpdateInfo.updatePriority() >= strategy.getUpdatePriority() /* 优先级等于高于4更新 */
                ) {
                    when (strategy.getUpdateType(appUpdateInfo.clientVersionStalenessDays())) {
                        UpdateType.FLEXIBLE -> {
                            if (strategy.showUpdateOfHome(appUpdateInfo.availableVersionCode()) || showUpdate) {
                                requestFlexibleUpdate(appUpdateInfo)
                            }
                        }

                        UpdateType.IMMEDIATE -> {
                            requestImmediateUpdate(appUpdateInfo)
                        }

                        else -> {

                        }
                    }
                }
            }
        }
    }

    private fun requestFlexibleUpdate(appUpdateInfo: AppUpdateInfo){
        // Request the update.
        appUpdateManager?.startUpdateFlowForResult(
            // Pass the intent that is returned by 'getAppUpdateInfo()'.
            appUpdateInfo,
            // an activity result launcher registered via registerForActivityResult
            activityResultLauncher,
            // Or pass 'AppUpdateType.FLEXIBLE' to newBuilder() for
            // flexible updates.
            AppUpdateOptions.newBuilder(AppUpdateType.FLEXIBLE).build()
        )
    }

    private fun requestImmediateUpdate(appUpdateInfo: AppUpdateInfo){
        // Request the update.
        appUpdateManager?.startUpdateFlowForResult(
            // Pass the intent that is returned by 'getAppUpdateInfo()'.
            appUpdateInfo,
            // an activity result launcher registered via registerForActivityResult
            activityResultLauncher,
            // Or pass 'AppUpdateType.FLEXIBLE' to newBuilder() for
            // flexible updates.
            AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
        )
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        if (strategy.isCheckInstall()) {
            appUpdateManager?.appUpdateInfo?.addOnSuccessListener { appUpdateInfo ->
                /**
                 * 已经监听下载完成时更新，为什么在onResume中再检测？
                 * 防止用户在多activity切换，导致监听注销。进而使下载完成后无法安装。
                 * 该处是对这种场景的补充处理。
                 */
                // If the update is downloaded but not installed,
                // notify the user to complete the update.
                if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                    popupSnackbarForCompleteUpdate()
                }
            }
        }

        if (strategy.isKeepImmediateUpdate()) {
            appUpdateManager?.appUpdateInfo?.addOnSuccessListener { appUpdateInfo ->
                /**
                 * 防止用户按back键退出立即更新
                 */
                if (appUpdateInfo.updateAvailability()
                    == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS
                ) {
                    // If an in-app update is already running, resume the update.
                    appUpdateManager?.startUpdateFlowForResult(
                        appUpdateInfo,
                        activityResultLauncher,
                        AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build()
                    )

                    /* //如果不需要监听回调，可以使用这种方式
                     appUpdateManager?.startUpdateFlowForResult(
                         appUpdateInfo,
                         activity,
                         AppUpdateOptions.newBuilder(AppUpdateType.IMMEDIATE).build(),1000)*/
                }

            }
        }

    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        appUpdateManager?.unregisterListener(this)
    }

    companion object {

        /**
         * 有升级时,添加提示信息.例如小红点,标签等等
         * 检查更新是异步的，使用回调处理
         */
        //todo 该检查更新未与配置未关联，待修复
        fun hasNewVersion(context: Context, callback: (Boolean) -> Unit) {
            try {
                val appUpdateManager = AppUpdateManagerFactory.create(context)
                appUpdateManager.appUpdateInfo.addOnSuccessListener {
                    callback(it.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE)
                }
            } catch (e: Exception) {
                callback(false)
                e.printStackTrace()
            }
        }
    }

}