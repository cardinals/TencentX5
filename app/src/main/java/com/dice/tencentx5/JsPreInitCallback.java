package com.dice.tencentx5;

import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * 创建时间： 2018/9/7:17:35
 * 创建人：renqi
 */
public class JsPreInitCallback implements QbSdk.PreInitCallback {

    @Override
    public void onViewInitFinished(boolean open) {
        Log.e("app", " onViewInitFinished is " + open);

    }

    @Override
    public void onCoreInitFinished() {
    }
}
