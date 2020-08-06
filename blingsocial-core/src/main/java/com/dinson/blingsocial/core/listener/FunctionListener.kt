package com.dinson.blingsocial.core.listener

import com.dinson.blingsocial.core.exception.SocialError
import com.dinson.blingsocial.core.model.LoginResult
import com.dinson.blingsocial.core.model.ShareEntity

/**
 * 函数变量申明
 */
class FunctionListener {

    var onStart: (() -> Unit)? = null

    var onShareStart: ((shareTarget: Int, obj: ShareEntity) -> Unit)? = null

    var onSuccess: (() -> Unit)? = null

    var onLoginSuccess: ((loginResult: LoginResult) -> Unit)? = null

    var onFailure: ((error: SocialError) -> Unit)? = null

    var onDealing: (() -> Unit)? = null

    var onCancel: (() -> Unit)? = null
}
