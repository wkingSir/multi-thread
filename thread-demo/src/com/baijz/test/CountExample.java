package com.baijz.test;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author baijianzhong
 * @ClassName CountExample
 * @Date 2019-06-24 10:43
 * @Description TODO
 **/
@Slf4j
public class CountExample {

    private static int THREAD_TOTAL = 200;
    private static int CLIENT_TOTAL = 50000;

    private static int count = 0;
    /**
     * 使用AtomicLong类进行控制
     */
//    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
        long time = System.currentTimeMillis();
        for( int i = 0; i < CLIENT_TOTAL; i++){
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println(" =============>>>>>>>>>>" + (System.currentTimeMillis() - time));
        System.out.println("count ： " + count);
    }

    /**
     * 加synchronized进行控制操作
     */
    private static synchronized void add(){
//        count.getAndIncrement() ;
        count++;
    }


}
