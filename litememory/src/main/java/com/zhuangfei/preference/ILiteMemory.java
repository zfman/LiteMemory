package com.zhuangfei.preference;

/**
 * Created by Liu ZhuangFei on 2019/6/1.
 */
public interface ILiteMemory {
    void save(Object object);
    <T> void get(Class<T> clazz);
    void delete();
}
