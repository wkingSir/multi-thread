package com.mmall.concurrency.multithread.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baijianzhong
 * @ClassName CyclicBarrierExample1
 * @Date 2019-07-08 12:26
 * @Description TODO 检测cyclicBarrier运行机制，当线程达到
 **/
@Slf4j
public class CyclicBarrierExample1 {

    //同步等待的值
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                }catch ( Exception e ){
                    log.error("{}",e);
                }
            });
        }

        executor.shutdown();

    }

    private static void race(int threadNum) throws Exception{
        log.info("thread {} has ready",threadNum);
        cyclicBarrier.await();
        log.info("thread {} continue",threadNum);
    }


}
