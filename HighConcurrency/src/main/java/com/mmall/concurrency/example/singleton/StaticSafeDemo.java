package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@ThreadSafe
public class StaticSafeDemo {

    // 私有构造函数
    private StaticSafeDemo() {

    }

    // 单例对象
    private static StaticSafeDemo instance = new StaticSafeDemo();

    // 静态的工厂方法
    public static StaticSafeDemo getInstance() {
        return instance;
    }
}
