package com.mmall.concurrency.multithread.example.commonUnsafe;

import com.mmall.concurrency.multithread.annotion.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author baijianzhong
 * @ClassName ArrayListExample1
 * @Date 2019-06-27 18:57
 * @Description TODO
 **/
@Slf4j
@NotThreadSafe
public class HashMapExample1 {

    private static Map<Integer,Integer> map = new HashMap<>();

    public static int threadTotal = 200;

    public static int clientTotal = 5000;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for ( int i = 0; i < clientTotal ; i++) {
            final Integer count = i;
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
        log.info("{}",map.size());
    }

    private static void add(Integer i) {
        try {
            map.put(i,i);
        } catch (Exception e){
            log.error(" parse Exception {}" , e);
        }
    }
}
