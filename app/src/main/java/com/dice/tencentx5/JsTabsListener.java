package com.dice.tencentx5;

import android.util.Log;

import com.tencent.smtt.sdk.TbsListener;

/**
 * 创建时间： 2018/9/7:17:33
 * 创建人：renqi
 */
public class JsTabsListener implements TbsListener {
    @Override
    public void onDownloadFinish(int i) {
        Log.d("app", "onDownloadFinish is " + i);
    }

    @Override
    public void onInstallFinish(int i) {
        Log.d("app", "onInstallFinish is " + i);
    }

    @Override
    public void onDownloadProgress(int i) {
        Log.d("app", "onDownloadProgress:" + i);
    }
}
