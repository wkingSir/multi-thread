package com.baijz.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author baijianzhong
 * @ClassName MapCountExample
 * @Date 2019-06-24 11:43
 * @Description TODO
 **/
public class MapCountExample {

    private static int THREAD_TOTAL =200;
    private static int CLIENT_TOTAL = 5000;

    /**
     * 换成线程安全的map
     */
    private static Map<Integer ,Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
        long time = System.currentTimeMillis();
        for( int i = 0; i < CLIENT_TOTAL; i++){
            final int key = i;
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    fun(key);
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println(" =============>>>>>>>>>>> 执行时间：" + (System.currentTimeMillis() - time));
        System.out.println(" the size of map : " + map.size());
    }

    /**
     * 方法上加 synchronized
     * @param param
     */
    private static  void fun(Integer param){
        map.put(param,param);
    }


}
