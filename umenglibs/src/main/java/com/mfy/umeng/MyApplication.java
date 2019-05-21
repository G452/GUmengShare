package com.mfy.umeng;

import android.app.Application;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //设置LOG开关，默认为false
        UMConfigure.setLogEnabled(true);//友盟登录分享推送通用
        UMShareAPI.get(this);//初始化友盟登录分享sdk
        //初始化APP key 友盟登录分享推送通用
        UMConfigure.init(this, "561cae6ae0f55abd990035bf", "", UMConfigure.DEVICE_TYPE_PHONE, "");

    }

    {
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //新浪微博(第三个参数为回调地址)
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com/sina2/callback");
        //QQ
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }


}
