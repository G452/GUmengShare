package text.g.com.gumengshare;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.mfy.umeng.loginModle.KUMAuthListener;
import com.mfy.umeng.loginModle.LoginUtils;
import com.mfy.umeng.loginModle.UmengBean;
import com.mfy.umeng.shareModle.KUMShareListener;
import com.mfy.umeng.shareModle.ShareUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.ShareBoardConfig;

import java.util.Map;

public class GUmeng extends AppCompatActivity implements View.OnClickListener {

    private Button qq_login;
    private Button qq_shared;
    private Button qqkj_shared;
    private Button weixin_login;
    private Button weixin_shared;
    private Button weixinpeng_shared;
    private Button weibo_login;
    private Button weibo_shared;
    private Button mianban;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gumeng);
        //初始化控件
        initView();
        //Android6.0权限:
        //因为分享授权中需要使用一些对应的权限，如果你的targetSdkVersion设置的是23或更高，
        // 需要提前获取权限。（如果targetSdkVersion是22或以下，可以忽略该问题）
        //动态读写权限
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }

    }

    /*
     * 初始化控件
     * */
    private void initView() {
        //获取控件强转提上去
        qq_login = (Button) findViewById(R.id.qq_login);
        qq_shared = (Button) findViewById(R.id.qq_shared);
        qqkj_shared = (Button) findViewById(R.id.qqkj_shared);
        weixin_login = (Button) findViewById(R.id.weixin_login);
        weixin_shared = (Button) findViewById(R.id.weixin_shared);
        weixinpeng_shared = (Button) findViewById(R.id.weixinpeng_shared);
        weibo_login = (Button) findViewById(R.id.weibo_login);
        weibo_shared = (Button) findViewById(R.id.weibo_shared);
        mianban = (Button) findViewById(R.id.mianban);
        //点击事件
        qq_login.setOnClickListener(this);
        qq_shared.setOnClickListener(this);
        qqkj_shared.setOnClickListener(this);
        weixin_login.setOnClickListener(this);
        weixin_shared.setOnClickListener(this);
        weixinpeng_shared.setOnClickListener(this);
        weibo_login.setOnClickListener(this);
        weibo_shared.setOnClickListener(this);
        mianban.setOnClickListener(this);

    }

    /*
     *点击事件
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qq_login:
                LoginUtils.login(GUmeng.this, 0, new KUMAuthListener() {
                    @Override
                    public void onCompleteBean(UmengBean bean, SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //用传进来的 umengBean 获取名字 头像 返回值
                        String name = bean.getName();
                        String gender = bean.getGender();
                        String iconurl = bean.getIconurl();
                        //在吐司显示
                        Toast.makeText(GUmeng.this, "qq登录成功返回值" + name + gender, Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.qq_shared:
                //分享 类型和四个空字符串
                LoginUtils.shared(GUmeng.this, 0, "", "", "", "",new KUMShareListener(true){
                });
                break;
            case R.id.qqkj_shared:
                //分享 类型和四个空字符串
                LoginUtils.shared(GUmeng.this, 3, "", "", "", "",new KUMShareListener(true){
                });
                break;
            case R.id.weixin_login:
                LoginUtils.login(GUmeng.this, 1, new KUMAuthListener() {
                    @Override
                    public void onCompleteBean(UmengBean bean, SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //用传进来的 umengBean 获取名字 头像 返回值
                        String name = bean.getName();
                        String gender = bean.getGender();
                        String iconurl = bean.getIconurl();
                        //在吐司显示
                        Toast.makeText(GUmeng.this, "微信登录成功返回值" + name + gender, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.weixin_shared:
                //分享 类型和四个空字符串
                LoginUtils.shared(GUmeng.this, 1, "", "", "", "",new KUMShareListener(true){
                });
                break;
            case R.id.weixinpeng_shared:
                //分享 类型和四个空字符串
                LoginUtils.shared(GUmeng.this, 4, "", "", "", "",new KUMShareListener(true){
                });
                break;
            case R.id.weibo_login:
                LoginUtils.login(GUmeng.this, 2, new KUMAuthListener() {
                    @Override
                    public void onCompleteBean(UmengBean bean, SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //用传进来的 umengBean 获取名字 头像 返回值
                        String name = bean.getName();
                        String gender = bean.getGender();
                        String iconurl = bean.getIconurl();
                        //在吐司显示
                        Toast.makeText(GUmeng.this, "微博登录成功返回值" + name + gender, Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.weibo_shared:
                //分享 类型和四个空字符串
                LoginUtils.shared(GUmeng.this, 2, "", "", "", "",new KUMShareListener(true){
                });
                break;
            case R.id.mianban:
                //带面板分享
                ShareUtils.shareMianB(this
                        ,"https://blog.csdn.net/qq_43143884"
                        , "M的CSDN"
                        ,"快来关注她吧~"
                        , "https://qlogo4.store.qq.com/qzone/2946268162/2946268162/100?1550039733"
                        , com.mfy.umeng.R.mipmap.icon,new KUMShareListener(true){
                        });
                break;
        }
    }

    /*
     * 回调返回数据
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}

