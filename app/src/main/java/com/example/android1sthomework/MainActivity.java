package com.example.android1sthomework;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;


public class MainActivity extends AppCompatActivity {

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();

        Button buttonLogin = (Button) findViewById(R.id.login_button);      //控制登录按钮
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在登陆...",Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonSinaWeibo = (Button) findViewById(R.id.sinaweibo_button);      //控制新浪微博按钮
        buttonSinaWeibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在跳转至新浪微博登录界面",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);             //跳转至新浪微博登录界面
                intent.setData(Uri.parse("https://weibo.com/login.php"));
                startActivity(intent);
            }
        });

        Button buttonTencentWeibo = (Button) findViewById(R.id.tencentweibo_button);      //控制腾讯微博按钮
        buttonTencentWeibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在跳转至腾讯微博登录界面",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);             //跳转至腾讯微博登录界面
                intent.setData(Uri.parse("https://weibo.com/login.php"));
                startActivity(intent);
            }
        });

        Button button_signup = (Button)findViewById(R.id.signup_button);        //页面跳转至注册页
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,signupActivity.class );
                startActivity(intent);
            }
        });

        EditText et_password = (EditText)findViewById(R.id.edittext_password);          //设置显示/隐藏密码
        Button btn_disppassword = (Button)findViewById(R.id.disp_password);
        et_password.setInputType(129);
        CheckBox checkBox = (CheckBox)findViewById(R.id.disp_password);
        btn_disppassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked() == true){
                    et_password.setInputType(128);
                }else{
                    et_password.setInputType(129);
                }

            }
        });


    }
}