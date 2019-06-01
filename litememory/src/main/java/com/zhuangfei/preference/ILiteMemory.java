package com.zhuangfei.preference;

/**
 * Created by Liu ZhuangFei on 2019/6/1.
 */
public interface ILiteMemory {
    <T> void save(T object);
    <T> T from(Class<T> clazz);
    <T> void delete(Class<T> clazz);
    <T> boolean exist(Class<T> clazz);
}
