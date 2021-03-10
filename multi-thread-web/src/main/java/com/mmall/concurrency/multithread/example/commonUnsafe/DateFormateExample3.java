package com.mmall.concurrency.multithread.example.commonUnsafe;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
public class DateFormateExample3 {

    public static int threadTotal = 200;

    public static int clientTotal = 5000;

    private static DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for ( int i = 0; i < clientTotal ; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
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

    private  static void update(int i) {

        log.info("{} , {} ",i,DateTime.parse("20190627",simpleDateFormat).toDate());

    }


}
