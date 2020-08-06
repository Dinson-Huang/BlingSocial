package com.dinson.blingsocial.alipay

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.alipay.sdk.app.PayTask
import com.dinson.blingsocial.core.SocialGo
import com.dinson.blingsocial.core.exception.SocialError
import com.dinson.blingsocial.core.listener.OnPayListener
import com.dinson.blingsocial.core.platform.AbsPlatform
import com.dinson.blingsocial.core.platform.IPlatform
import com.dinson.blingsocial.core.platform.PlatformCreator
import com.dinson.blingsocial.core.platform.Target.PAY_ALI

/**
 * 支付宝支付平台
 */
class AliPlatform(appId: String?, appName: String?) : AbsPlatform(appId, appName) {

    class Creator : PlatformCreator {
        override fun create(context: Context, target: Int): IPlatform {
            return AliPlatform("", SocialGo.getConfig().getAppName())
        }
    }

    override fun isInstall(context: Context): Boolean {
        return mTarget == PAY_ALI
    }

    override fun doPay(context: Context, params: String, listener: OnPayListener) {
        val payTask = PayTask(context as Activity)
        SocialGo.getExecutor().execute {
            val payResult = payTask.payV2(params, true)
            SocialGo.getHandler().post {
                if (payResult != null) {
                    val resultStatus = payResult["resultStatus"]
                    when {
                        TextUtils.equals(resultStatus, "9000") -> //支付成功
                            listener.getFunction().onSuccess?.invoke()
                        TextUtils.equals(
                            resultStatus,
                            "8000"
                        ) -> //支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                            listener.getFunction().onDealing?.invoke()
                        TextUtils.equals(resultStatus, "6001") -> //支付取消
                            listener.getFunction().onCancel?.invoke()
                        TextUtils.equals(resultStatus, "6002") -> //网络连接出错
                            listener.getFunction().onFailure?.invoke(SocialError(SocialError.CODE_REQUEST_ERROR))
                        TextUtils.equals(resultStatus, "4000") -> //支付错误
                            listener.getFunction().onFailure?.invoke(SocialError(SocialError.CODE_PAY_ERROR))
                    }
                } else {
                    listener.getFunction().onFailure?.invoke(SocialError(SocialError.CODE_PAY_RESULT_ERROR))
                }
            }
        }
    }
}
