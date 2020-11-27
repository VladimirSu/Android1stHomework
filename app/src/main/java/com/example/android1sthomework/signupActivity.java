package com.example.android1sthomework;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.SaveInfo;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    private SharedPreferences loginPreference;
    private EditText userName1;
    private EditText password1;
    private EditText password2;
    protected boolean useThemestatusBarColor = false;               //定义沉浸式状态栏
    protected boolean useStatusBarColor = true;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected String username;
    protected String password;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void setStatusBar(){
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //设置状态栏文字颜色及图标为深色
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        Button backtoLogin = (Button) findViewById(R.id.backtologin_button);         //点击返回按钮回到主界面
        backtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Button signupBtn = (Button) findViewById(R.id.signup_button);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName1 = findViewById(R.id.edittext_account_signup);
                password1 = findViewById(R.id.edittext_password_signup);
                password2 = findViewById(R.id.edittext_passwordagain_signup);
                String username = userName1.getText().toString().trim();
                String password = password1.getText().toString().trim();
                String passwordagain = password2.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordagain)) {
                    Toast.makeText(signupActivity.this, "各项均不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.equals(password, passwordagain)) {
                        //执行注册操作
                        Toast.makeText(signupActivity.this, "注册成功,请返回登录", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signupActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(signupActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        });


    }
}