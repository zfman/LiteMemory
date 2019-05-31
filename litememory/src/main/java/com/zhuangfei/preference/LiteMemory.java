package com.zhuangfei.preference;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

/**
 * Created by Liu ZhuangFei on 2019/6/1.
 */
public class LiteMemory implements ILiteMemory {

    Context context;

    private LiteMemory(){}

    public static LiteMemory with(@NonNull Context context){
        LiteMemory preference=new LiteMemory();
        preference.context=context;
        return preference;
    }

    @Override
    public void save(Object object) {

    }

    @Override
    public <T> void get(Class<T> clazz) {
        String key=clazz.getPackage()+"."+clazz.getSimpleName();
        Toast.makeText(context,key,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delete() {

    }
}
