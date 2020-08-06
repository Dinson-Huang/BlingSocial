package com.dinson.blingsocial.wechat.model

import com.dinson.blingsocial.core.model.token.AccessToken
import com.dinson.blingsocial.core.platform.Target

/**
 * 微信的AccessToken
 */
class WeChatAccessToken : AccessToken() {

    val refresh_token: String? = null//用户刷新access_token。
    val scope: String? = null//用户授权的作用域，使用逗号（,）分隔
    val errcode: Int = 0
    val errmsg: String? = null

    val isNoError: Boolean
        get() = errcode == 0

    override fun loginTarget(): Int {
        return Target.LOGIN_WX
    }
}