package com.mmall.concurrency.multithread.atomic;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author baijianzhong
 * @ClassName ConcurrencyTest2
 * @Date 2019-06-24 21:26
 * @Description TODO
 **/
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    public static AtomicReference<Integer> count = new AtomicReference(0);

    public static void main(String[] args) throws Exception{
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        System.out.println(count.get());
    }

}
