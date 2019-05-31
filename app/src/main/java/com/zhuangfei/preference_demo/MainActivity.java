package com.zhuangfei.preference_demo;

import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuangfei.preference.LiteMemory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user=new User();
        user.setName("刘壮飞");
        LiteMemory.with(this).save(user);
    }
}
