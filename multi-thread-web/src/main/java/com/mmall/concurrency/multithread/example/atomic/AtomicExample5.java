package com.mmall.concurrency.multithread.example.atomic;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author baijianzhong
 * @ClassName ConcurrencyTest2
 * @Date 2019-06-24 21:26
 * @Description TODO
 **/
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    @Getter
    private volatile int count = 100;

    static AtomicExample5 atomicExample5 = new AtomicExample5();

    static AtomicIntegerFieldUpdater<AtomicExample5> arfu = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    public static void main(String[] args) throws Exception{
        if(arfu.compareAndSet(atomicExample5,100,120)){
            log.info("==============>>>>> {} " ,atomicExample5.getCount());
        }

        if(arfu.compareAndSet(atomicExample5,100,120)){
            log.info("==============>>>>> update success 2 {}" ,atomicExample5.getCount());
        }else{
            log.info("==============>>>>> update failed, {}" ,atomicExample5.getCount());
        }
    }

}
