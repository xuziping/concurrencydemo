package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class UpdateFieldDemo {

    private static AtomicIntegerFieldUpdater<UpdateFieldDemo> updater =
            AtomicIntegerFieldUpdater.newUpdater(UpdateFieldDemo.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        UpdateFieldDemo example5 = new UpdateFieldDemo();

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 1, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 2, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}
