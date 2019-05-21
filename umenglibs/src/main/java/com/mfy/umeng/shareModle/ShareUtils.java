package com.mfy.umeng.shareModle;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.PopupWindow;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.ShareBoardConfig;

/**
 * 友盟分享工具类
 * 3、6月份新版微信客户端发布后，用户从App中分享消息给微信好友
 * ，或分享到朋友圈时，开发者将无法获知用户是否分享完成。具体调整点为：
 * （1）分享接口调用后，不再返回用户是否分享完成事件，即原先的cancel事件和success事件将统一为success事件。
 */
public class ShareUtils {

    /**
     * 不带面板，分享链接
     */
    public static void shareWeb(final Activity activity, String WebUrl, String title,
                                String description, String imageUrl, int imageID, SHARE_MEDIA platform
            , final KUMShareListener listener) {
        UMWeb web = new UMWeb(WebUrl);//连接地址
        web.setTitle(title);//标题
        web.setDescription(description);//描述
        if (TextUtils.isEmpty(imageUrl)) {
            web.setThumb(new UMImage(activity, imageID));  //本地缩略图
        } else {
            web.setThumb(new UMImage(activity, imageUrl));  //网络缩略图
        }
        new ShareAction(activity)
                .setPlatform(platform)
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        listener.onStart(share_media);
                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        listener.onResult(share_media);
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        listener.onError(share_media, throwable);
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        listener.onCancel(share_media);
                    }
                })
                .share();

        /*//新浪微博中图文+链接
        new ShareAction(activity)
                .setPlatform(platform)
                .withText(description + " " + WebUrl)
                .withMedia(new UMImage(activity,imageID))
                .share();*/
    }

    /*
     * 带面板分享
     *
     * */
    public static void shareMianB(final Activity activity, String WebUrl, String title, String description, String imageUrl, int imageID, final KUMShareListener listener) {
        UMWeb web = new UMWeb(WebUrl);//连接地址
        web.setTitle(title);//标题
        web.setDescription(description);//描述
        if (TextUtils.isEmpty(imageUrl)) {
            web.setThumb(new UMImage(activity, imageID));  //本地缩略图
        } else {
            web.setThumb(new UMImage(activity, imageUrl));  //网络缩略图
        }
        new ShareAction(activity)
                .withMedia(web)
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN_FAVORITE)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        listener.onStart(share_media);
                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        listener.onResult(share_media);
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        listener.onError(share_media, throwable);
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        listener.onCancel(share_media);
                    }
                }).open(new ShareBoardConfig().setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                listener.onCancel(null);
            }
        }));

    }

}
