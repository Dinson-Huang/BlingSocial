package com.dinson.blingsocial.core.listener

import com.dinson.blingsocial.core.exception.SocialError
import com.dinson.blingsocial.core.model.LoginResult

/**
 * 登录回调
 */
interface OnLoginListener {

    fun getFunction(): FunctionListener

    fun onStart(start: () -> Unit) {
        getFunction().onStart = start
    }

    fun onSuccess(success: (result: LoginResult) -> Unit) {
        getFunction().onLoginSuccess = success
    }

    fun onCancel(cancel: () -> Unit) {
        getFunction().onCancel = cancel
    }

    fun onFailure(failure: (error: SocialError) -> Unit) {
        getFunction().onFailure = failure
    }

}
