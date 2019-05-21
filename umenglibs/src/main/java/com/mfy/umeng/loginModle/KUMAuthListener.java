package com.mfy.umeng.loginModle;

import android.util.Log;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;

/*
* 登录成功取消监听
* */

public class KUMAuthListener implements UMAuthListener {
    private static String TAG = "登录结果==";
    @Override
    public void onStart(SHARE_MEDIA share_media) {
        Log.d(TAG, "onStart " + "授权开始");
    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        Log.i(TAG, "onComplete " + "授权完成");

    }

    //一般调用这个类  有UmengBean
    public void onCompleteBean(UmengBean bean, SHARE_MEDIA share_media, int i, Map<String, String> map) {
        Log.i(TAG, "onCompleteBean" + "授权完成+结果bean");
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        Log.i(TAG, "onError " + "授权失败");
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        Log.d(TAG, "onCancel " + "授权取消");
    }
}
