package com.mmall.concurrency.multithread.example.commonUnsafe;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author baijianzhong
 * @ClassName DateFormateExample1
 * @Date 2019-06-27 16:03
 * @Description TODO
 **/
@Slf4j
@ThreadSafe
public class DateFormateExample2 {

    public static int threadTotal = 200;

    public static int clientTotal = 5000;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for ( int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception ", e);
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private  static void update() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            simpleDateFormat.parse("20190627");
        } catch (Exception e){
            log.error(" parse Exception {}" , e);
        }
    }


}
