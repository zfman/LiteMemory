package com.zhuangfei.preference_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zhuangfei.preference.LiteMemory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user=new User();
        user.setName("刘壮飞");
        user.setAge(23);
        LiteMemory.get().save(user);

        boolean has=LiteMemory.get().exist(User.class);

        LiteMemory.get().delete(User.class);

        User newUser=LiteMemory.get().from(User.class);
        Toast.makeText(this,"newUser:"+has+";"+newUser.getName(),Toast.LENGTH_SHORT).show();
    }
}
