package com.mmall.concurrency.multithread.example.singleton;

import com.mmall.concurrency.multithread.annotion.Recommend;
import com.mmall.concurrency.multithread.annotion.ThreadSafe;

/**
 * @author baijianzhong
 * @ClassName SingletonExample1
 * @Date 2019-06-26 16:30
 * @Description TODO
 *
 *  懒汉模式————>双重同步锁单例模式
 *
 **/
@ThreadSafe
@Recommend
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }

    /**
     * cpu对象创建
     *  1.allocate 分配对象内存空间
     *  2.ctorInstance() 初始化对象
     *  3.设置instance = memory 设置instance指向刚分配的内存
     */

    //单例对象 volatile + 双重检测机制；禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态工厂方法
    public static synchronized SingletonExample5 getInstance(){
        if(instance == null ){//双重检测机制
            synchronized (SingletonExample5.class) {//同步锁
                if(instance == null ) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }

}
