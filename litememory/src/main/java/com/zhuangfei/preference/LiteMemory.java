package com.zhuangfei.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import javax.microedition.khronos.egl.EGLDisplay;

/**
 * Created by Liu ZhuangFei on 2019/6/1.
 */
public class LiteMemory implements ILiteMemory {

    private static Context context;
    private static LiteMemory instance;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    public static final String KEY_PREFERENCE = "litememory_preference";

    private LiteMemory() {
        preferences = context.getSharedPreferences(KEY_PREFERENCE, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    private static void ensureInstance() {
        if (context == null) {
            throw new RuntimeException("LiteMemory:Context is null,you should call"
                    + "`LiteMemory.initialize(context)` before."
                    + "Or you can call `LiteMemory.initialize(context)` in application#onCreate");
        }
        if (instance == null) {
            synchronized (LiteMemory.class) {
                if (instance == null) {
                    instance = new LiteMemory();
                }
            }
        }
    }

    /**
     * 初始化，必须在调用其他方法前调用初始化方法.
     * 一般的，应该在Applicaion#onCreate中调用
     *
     * @param ctx
     */
    public static void initialize(@NonNull Context ctx) {
        context = ctx;
    }

    @Override
    public <T> void save(T object) {
        ensureInstance();
        String value = JSON.toJSONString(object);
        editor.putString(getKey(object.getClass()), value);
        editor.commit();
    }

    @Override
    public <T> T from(Class<T> clazz) {
        ensureInstance();
        String value = preferences.getString(getKey(clazz), null);
        if (value == null) {
            try {
                T newInstance = clazz.newInstance();
                return newInstance;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        T t = JSON.parseObject(value, clazz);
        return t;
    }

    @Override
    public <T> void delete(Class<T> clazz) {
        ensureInstance();
        editor.putString(getKey(clazz),null);
        editor.commit();
    }

//    public <T> void from(Class<T> clazz) {
//        ensureInstance();
//        editor.putString(getKey(clazz),null);
//        editor.commit();
//    }

    private <T> String getKey(Class<T> clazz) {
        String key = clazz.getClass().getName();
        return key;
    }

    public static LiteMemory get(){
        ensureInstance();
        return instance;
    }
}
