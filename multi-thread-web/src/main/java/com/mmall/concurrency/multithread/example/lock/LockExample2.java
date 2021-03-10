package com.mmall.concurrency.multithread.example.lock;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author baijianzhong
 * @ClassName ConcurrencyTest2
 * @Date 2019-06-24 21:26
 * @Description TODO
 **/
@Slf4j
@ThreadSafe
public class LockExample2 {

    private static Map<String, Date> map = new TreeMap<>();

    private final static ReadWriteLock lock = new ReentrantReadWriteLock();

    private final static Lock readLock = lock.readLock();
    private final static Lock writeLock = lock.writeLock();


    public Date getDate(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getDateSet() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public Date putDate() {
        writeLock.lock();
        try {
            return map.put("current", new Date());
        } finally {
            writeLock.unlock();
        }
    }
}
