package com.mmall.concurrency.multithread.example.atomic;

import com.mmall.concurrency.multithread.annotion.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author baijianzhong
 * @ClassName AtomicExample2
 * @Date 2019-06-24 21:26
 * @Description TODO
 **/
@Slf4j
@NotThreadSafe
public class AtomicExample6 {

    public static int threadTotal = 50;

    public static int clientTotal = 5000;

    public static AtomicBoolean flag = new AtomicBoolean(true);

    public static int count = 0;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for ( int i = 0; i < clientTotal ; i++) {
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
        log.info(" count: {}" , count);
    }

    private static void add() {
        if(flag.compareAndSet(true,false)) {
            count++;
        }
    }
}
