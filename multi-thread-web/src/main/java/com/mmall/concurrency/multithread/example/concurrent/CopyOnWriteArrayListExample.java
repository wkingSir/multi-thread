package com.mmall.concurrency.multithread.example.concurrent;

import com.mmall.concurrency.multithread.annotion.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author baijianzhong
 * @ClassName ArrayListExample1
 * @Date 2019-06-27 18:57
 * @Description TODO
 **/
@Slf4j
@NotThreadSafe
public class CopOnWriteArrayListExample {

    private static List<Integer> list = new CopyOnWriteArrayList<>();

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
        log.info("{}",list.size());
    }

    private static void add(int i) {
        log.info("{}", i);
        list.add(i);
    }
}
