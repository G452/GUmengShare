package com.mfy.umeng.loginModle;

import android.app.Activity;
import android.text.TextUtils;
import com.mfy.umeng.shareModle.KUMShareListener;
import com.mfy.umeng.R;
import com.mfy.umeng.shareModle.ShareUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;

/**
 * 登录分享工具类
 */
public class LoginUtils {
    private static String TAG ="LoginUtils";

    /**
     * 登录调用方法
     * type类型
     * 0:QQ登录
     * 1：微信登录
     * 2：新浪登录
     */
    public static void login(Activity context, int type, final KUMAuthListener listener) {
        SHARE_MEDIA state = SHARE_MEDIA.QQ;
        if (type == 0) {
            state = SHARE_MEDIA.QQ;
        } else if (type == 1) {
            state = SHARE_MEDIA.WEIXIN;
        } else if (type == 2) {
            state = SHARE_MEDIA.SINA;
        }
        UMShareAPI.get(context).getPlatformInfo(context, state, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                listener.onStart(share_media);
            }
            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                listener.onComplete(share_media, i, map);
                //获取值
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String unionid = map.get("unionid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");

                UmengBean umengBean = new UmengBean();
                umengBean.setUid(uid);
                umengBean.setOpenid(openid);
                umengBean.setUnionid(unionid);
                umengBean.setAccess_token(access_token);
                umengBean.setRefresh_token(refresh_token);
                umengBean.setExpires_in(expires_in);
                umengBean.setName(name);
                umengBean.setGender(gender);
                umengBean.setIconurl(iconurl);
                if (umengBean != null) {
                    listener.onCompleteBean(umengBean, share_media, i, map);
                }
                //拿到信息去请求登录接口。。。
            }
            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                listener.onError(share_media, i, throwable);
            }
            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                listener.onCancel(share_media, i);
            }
        });
    }


    /***
     * 分享
     *      context 为上下文，可传this
     *      type 为类型 0 ：QQ分享，1：微信分享，2：新浪微博分享，3：QQ空间分享，4：微信朋友圈分享
     *      title 为分享标题
     *      desc 为分享描述
     *      image 为分享图片链接
     *      link  为跳转链接
     *
     *      参数可传空，为空则取默认值
     *
     * */
    public static void shared(Activity context, int type, String title,
                              String desc, String image, String link,final KUMShareListener listener) {
        if (TextUtils.isEmpty(title)) {
            title = "M的CSDN";
        }
        if (TextUtils.isEmpty(desc)) {
            desc = "快来关注她吧~";
        }
        if (TextUtils.isEmpty(image)) {
            image = "https://qlogo4.store.qq.com/qzone/2946268162/2946268162/100?1550039733";
        }
        if (TextUtils.isEmpty(link)) {
            link = "https://blog.csdn.net/qq_43143884";
        }
        SHARE_MEDIA state = SHARE_MEDIA.QQ;
        if (type == 0) {
            state = SHARE_MEDIA.QQ;//QQ
        } else if (type == 1) {
            state = SHARE_MEDIA.WEIXIN;//微信
        } else if (type == 2) {
            state = SHARE_MEDIA.SINA;//新浪
        } else if (type == 3) {
            state = SHARE_MEDIA.QZONE;//qq空间
        } else if (type == 4) {
            state = SHARE_MEDIA.WEIXIN_CIRCLE;//微信朋友圈
        }
        ShareUtils.shareWeb(context, link, title
                , desc, image, R.mipmap.icon, state
        ,listener);
    }

}
