package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@ThreadSafe
public class StaticSafeDemo2 {

    // 私有构造函数
    private StaticSafeDemo2() {

    }

    // 单例对象
    private static StaticSafeDemo2 instance = null;

    static {
        instance = new StaticSafeDemo2();
    }

    // 静态的工厂方法
    public static StaticSafeDemo2 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
