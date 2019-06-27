package com.mmall.concurrency.multithread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baijianzhong
 * @ClassName SynchronizedExample1
 * @Date 2019-06-26 10:09
 * @Description TODO
 **/
@Slf4j
public class SynchronizedExample1 {

    /**
     * 修饰代码段
     */
    public void test1(int j) {
        synchronized (this){
            for ( int i = 0 ; i < 10 ; i++){
                log.info("===============>> test1 - {} — {}",j,i);
            }
        }
    }

    /**
     * 修饰方法
     */
    public synchronized void test2(int j) {
        for ( int i = 0 ; i < 10 ; i++){
            log.info("===============>> test2 - {} — {}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService1.execute(() -> {
            synchronizedExample1.test1(1);
        });
        executorService2.execute(() -> {
            synchronizedExample2.test2(2);
        });

        executorService1.shutdown();
        executorService2.shutdown();
    }

}
