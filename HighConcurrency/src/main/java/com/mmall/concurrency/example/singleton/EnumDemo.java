package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.Recommend;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class EnumDemo {

    // 私有构造函数
    private EnumDemo() {

    }

    public static EnumDemo getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private EnumDemo singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new EnumDemo();
        }

        public EnumDemo getInstance() {
            return singleton;
        }
    }
}
