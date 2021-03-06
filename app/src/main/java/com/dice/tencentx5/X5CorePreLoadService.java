package com.dice.tencentx5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

import java.util.HashMap;

/**
 * 创建时间： 2018/9/18:11:08
 * 创建人：renqi
 */
public class X5CorePreLoadService extends IntentService {
    private static final String TAG = X5CorePreLoadService.class.getSimpleName();

    public X5CorePreLoadService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //在这里添加我们要执行的代码，Intent中可以保存我们所需的数据，
        //每一次通过Intent发送的命令将被顺序执行
        initX5(intent);
    }

    /**
     * 初始化X5内核
     */
    private void initX5(Intent intent) {
        if (!QbSdk.isTbsCoreInited()) {
            QbSdk.preInit(getApplicationContext(), cb);// 设置X5初始化完成的回调接口
        }
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        QbSdk.initTbsSettings(map);
        QbSdk.setTbsListener(new JsTabsListener());
        QbSdk.initX5Environment(getApplicationContext(), cb);

    }

    QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

        @Override
        public void onViewInitFinished(boolean b) {
            // TODO Auto-generated method stub
            //初始化完成回调
            Log.e("app", "-------------x5内核使用：" + b);
        }

        @Override
        public void onCoreInitFinished() {
            // TODO Auto-generated method stub
        }
    };
}
