package com.mmall.concurrency.multithread.example.concurrent;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author baijianzhong
 * @ClassName ArrayListExample1
 * @Date 2019-06-27 18:57
 * @Description TODO
 *
 * CopyOnWriteArrayList在并发的环境中适合读操作，写操作也可以保证线程安全
 *
 **/
@Slf4j
@ThreadSafe
public class ConcurrentArraySetExample {

    private static Set<Integer> list = new ConcurrentArraySet<Integer>();

    public static int threadTotal = 200;

    public static int clientTotal = 5000;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for ( int i = 0; i < clientTotal ; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception ", e);
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        Thread.sleep(1000);
        log.info("{}",list.size());
    }

    private static void add(int i) {
        log.info("{}", i);
        list.add(i);
    }
}
