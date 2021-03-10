package com.mmall.concurrency.multithread.example.syncContainer;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author baijianzhong
 * @ClassName ArrayListExample1
 * @Date 2019-06-27 18:57
 * @Description TODO
 *
 * vector类不绝对安全，看方法的调用
 *
 **/
@Slf4j
@ThreadSafe
public class VectorExample2 {

    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) throws Exception {

        while (true) {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        list.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        list.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }

}
