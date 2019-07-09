package com.mmall.concurrency.multithread.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author baijianzhong
 * @ClassName CountDownLatchExample1
 * @Date 2019-06-28 10:19
 * @Description TODO 在线程未执行结束就执行以下的方法
 **/
@Slf4j
public class SemExample2 {

    private static int threadCount = 20;

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int count  = i;
            executorService.execute(()->{
                try{
                    semaphore.acquire();// 获取一个许可
                    test(count);
                    semaphore.release();// 释放一个许可
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        executorService.shutdown();
        log.info("finish");
    }

    private static void test(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{}",threadNum);
    }

}
