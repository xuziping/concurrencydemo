package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式 -》 双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SynchronizedCodeUnsafeDemo {

    // 私有构造函数
    private SynchronizedCodeUnsafeDemo() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    // 单例对象
    private static SynchronizedCodeUnsafeDemo instance = null;

    // 静态的工厂方法
    public static SynchronizedCodeUnsafeDemo getInstance() {
        if (instance == null) { // 双重检测机制        // B
            synchronized (SynchronizedCodeUnsafeDemo.class) { // 同步锁
                if (instance == null) {
                    instance = new SynchronizedCodeUnsafeDemo(); // A - 3
                }
            }
        }
        return instance;
    }
}
