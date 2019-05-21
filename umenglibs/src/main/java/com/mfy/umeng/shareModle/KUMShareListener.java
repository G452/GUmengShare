package com.mfy.umeng.shareModle;

import android.util.Log;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/*
 * 分享  开始 失败  回调 取消 监听
 * */
public class KUMShareListener implements UMShareListener {
    private String TAG = "KUMShareListener";
    private boolean tag = true;
    //构造方法 传tag判断进行log或者其他操作
    public KUMShareListener(boolean tag) {
        this.tag = tag;
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {
        if (tag) {
            Log.i(TAG, "onStart " + "分享成功开始");
        }
    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        if (tag) {
            if (share_media.name().equals("WEIXIN_FAVORITE")) {
                Log.i(TAG, "onResult " + "收藏成功");
            } else {
                Log.i(TAG, "onResult " + "分享成功");
            }
        }

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
        if (tag) {
            if (throwable != null) {
                Log.i("throw", "throw:" + throwable.getMessage());
            }
            Log.i(TAG, "onError " + "分享失败");
        }
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        if (tag) {
            Log.i(TAG, "onCancel " + "分享取消");
        }
    }
}
