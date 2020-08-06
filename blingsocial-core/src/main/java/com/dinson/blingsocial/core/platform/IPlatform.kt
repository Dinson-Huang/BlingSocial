package com.dinson.blingsocial.core.platform

import android.app.Activity
import android.content.Context

import com.dinson.blingsocial.core.listener.OnLoginListener
import com.dinson.blingsocial.core.listener.OnPayListener
import com.dinson.blingsocial.core.listener.OnShareListener
import com.dinson.blingsocial.core.listener.PlatformLifecycle
import com.dinson.blingsocial.core.model.ShareEntity


/**
 * 定义第三方平台接口协议
 */
interface IPlatform : PlatformLifecycle {

    /**
     * 获取中间页的Clazz
     */
    fun getActionClazz(): Class<*>

    /**
     * 是否安装
     */
    fun isInstall(context: Context): Boolean

    /**
     * 发起登录
     */
    fun login(activity: Activity, listener: OnLoginListener)

    /**
     * 发起分享
     */
    fun share(activity: Activity, target: Int, entity: ShareEntity, listener: OnShareListener)

    /**
     * 支付
     */
    fun doPay(context: Context, params: String, listener: OnPayListener)
}
