package com.dinson.blingsocial.core.platform

import android.app.Activity
import com.dinson.blingsocial.core.listener.OnShareListener
import com.dinson.blingsocial.core.model.ShareEntity

/**
 * 分享类型
 */
interface IShareAction {

    fun shareOpenApp(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun shareText(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun shareImage(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun shareApp(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun shareWeb(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun shareMusic(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun shareVideo(shareTarget: Int, activity: Activity, entity: ShareEntity)

    fun share(activity: Activity, target: Int, entity: ShareEntity, listener: OnShareListener) {
        when (entity.getShareType()) {
            ShareEntity.SHARE_OPEN_APP -> shareOpenApp(target, activity, entity)
            ShareEntity.SHARE_TYPE_TEXT -> shareText(target, activity, entity)
            ShareEntity.SHARE_TYPE_IMAGE -> shareImage(target, activity, entity)
            ShareEntity.SHARE_TYPE_APP -> shareApp(target, activity, entity)
            ShareEntity.SHARE_TYPE_WEB -> shareWeb(target, activity, entity)
            ShareEntity.SHARE_TYPE_MUSIC -> shareMusic(target, activity, entity)
            ShareEntity.SHARE_TYPE_VIDEO -> shareVideo(target, activity, entity)
        }
    }
}