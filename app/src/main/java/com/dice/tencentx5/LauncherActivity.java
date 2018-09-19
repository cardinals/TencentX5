package com.dice.tencentx5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.List;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        // 动态权限申请
        AndPermission.with(LauncherActivity.this)
                .permission(
                        Permission.Group.STORAGE, // 存储空间
                        Permission.Group.LOCATION, // 位置
                        Permission.Group.CALENDAR,// 日历
                        Permission.Group.PHONE// 手机权限
                ).onDenied(new Action() {
            @Override
            public void onAction(List<String> permissions) {



            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(LauncherActivity.this,MainActivity.class));
                break;
        }
    }
}
