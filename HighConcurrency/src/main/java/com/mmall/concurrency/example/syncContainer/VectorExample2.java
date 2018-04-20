package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annoations.NotThreadSafe;

import java.util.Vector;

@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws Exception{


            for (int i = 0; i < 500000; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                        try {
                            Thread.sleep(100);
                        } catch(Exception e) {
                        }
                    }
                }
            };
            thread1.start();
            thread2.start();
    }
}
