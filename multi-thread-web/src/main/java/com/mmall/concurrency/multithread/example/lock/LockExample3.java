package com.mmall.concurrency.multithread.example.lock;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author baijianzhong
 * @ClassName ConcurrencyTest2
 * @Date 2019-06-24 21:26
 * @Description TODO
 **/
@Slf4j
@ThreadSafe
public class LockExample3 {

    public static int threadTotal = 50;

    public static int clientTotal = 5000;

    public static int count = 0;

    private final static StampedLock lock = new StampedLock();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception ", e);
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info(" count: {}", count);
    }

    private static void add() {
        long stamp = lock.writeLock();
        try{
            count++;
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}
