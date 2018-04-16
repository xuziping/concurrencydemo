package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
public class SynchronizedMethodSafeDemo {

    // 私有构造函数
    private SynchronizedMethodSafeDemo() {

    }

    // 单例对象
    private static SynchronizedMethodSafeDemo instance = null;

    // 静态的工厂方法
    public static synchronized SynchronizedMethodSafeDemo getInstance() {
        if (instance == null) {
            instance = new SynchronizedMethodSafeDemo();
        }
        return instance;
    }
}
