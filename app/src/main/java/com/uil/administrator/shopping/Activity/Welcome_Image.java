package com.uil.administrator.shopping.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.ImageView;


import com.uil.administrator.shopping.Adapter.BaseActivity;
import com.uil.administrator.shopping.R;

import java.util.Random;

public class Welcome_Image extends BaseActivity {

    private ImageView iv;
    private Handler handler;

    @Override
    protected int contentView() {
        return R.layout.activity_welcome_image;
    }

    /**
     *  初始化方法
     */
    @Override
    protected void initView() {

        iv = (ImageView) findViewById(R.id.welcome_iv);
        handler = new Handler();
    }

    /**
     *  加载数据
     */
    @Override
    protected void dataLoad() {

        // 添加随机数用于展示随机图片
        Random ra =new Random();
        int imageId = getResources().getIdentifier("iv_guide_"+ra.nextInt(3),"mipmap",getPackageName());
        iv.setImageResource(imageId);
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst", true);
        if (isFirst == true) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isFirst", false);
            //4.提交
            editor.commit();
            //应用首次启动
            // 等待3秒后执行跳转
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Welcome_Image.this, Welcome_page.class));
                    finish();
                }
            }, 2000);
        }else{
            //二次启动
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Welcome_Image.this, MainActivity.class));
                    finish();
                }
            }, 2000);
        }
    }
}

