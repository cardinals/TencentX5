package com.dice.tencentx5;

import android.app.Application;
import android.content.Intent;

import com.tencent.smtt.sdk.QbSdk;

/**
 * 创建时间： 2018/9/4:21:55
 * 创建人：renqi
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        preInitX5Core();
    }
    /**
     * 初始化X5内核
     */
    private void preInitX5Core() {
        //预加载x5内核
        Intent intent = new Intent(this, X5CorePreLoadService.class);
        startService(intent);
    }
    private void init(){

        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
                //X5内核初始化完成，true使用x5内核，false使用系统内核
                System.out.println("-------------x5内核使用：" + b);
            }
        };
        //x5内核初始化
        QbSdk.initX5Environment(getApplicationContext(), cb);

    }
}
