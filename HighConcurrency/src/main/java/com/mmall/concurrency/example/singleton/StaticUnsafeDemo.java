package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class StaticUnsafeDemo {

    // 私有构造函数
    private StaticUnsafeDemo() {

    }

    // 单例对象
    private static StaticUnsafeDemo instance = null;

    // 静态的工厂方法
    public static StaticUnsafeDemo getInstance() {
        if (instance == null) {
            instance = new StaticUnsafeDemo();
        }
        return instance;
    }
}
