package com.dinson.blingsocial.wechat.uikit

import com.dinson.blingsocial.core.uikit.BaseActionActivity
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler

class WxActionActivity : BaseActionActivity(), IWXAPIEventHandler {

    override fun onResp(resp: BaseResp) {
        handleResp(resp)
    }

    override fun onReq(p0: BaseReq?) {
    }
}