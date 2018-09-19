package com.dice.tencentx5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.Touch;
import android.widget.Toast;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView forum_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (forum_context.getX5WebViewExtension() != null){
            Toast.makeText(this,"true",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
        }

        forum_context.loadUrl("http://soft.imtt.qq.com/browser/tes/feedback.html");

    }

    private void initView() {
        forum_context = (WebView) findViewById(R.id.forum_context);
        WebSettings settings = forum_context.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + "js_nativeApp");
        settings.setJavaScriptEnabled(true);
    }
}
