package com.mmall.concurrency.multithread.example.singleton;

import com.mmall.concurrency.multithread.annotion.NotRecommend;
import com.mmall.concurrency.multithread.annotion.NotThreadSafe;

/**
 * @author baijianzhong
 * @ClassName SingletonExample1
 * @Date 2019-06-26 16:30
 * @Description TODO
 *
 *  懒汉模式————>双重同步锁单例模式
 *
 **/
@NotThreadSafe
@NotRecommend
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4(){

    }

    /**
     * cpu对象创建
     *  1.allocate 分配对象内存空间
     *  2.ctorInstance() 初始化对象
     *  3.设置instance = memory 设置instance指向刚分配的内存
     */

    /**
     * JVM 和 cpu优化，发生了指令重排
     *  1.allocate 分配对象内存空间
     *  3.设置instance = memory 设置instance指向刚分配的内存
     *  2.ctorInstance() 初始化对象
     */

    //单例对象
    private static SingletonExample4 instance = null;

    //静态工厂方法
    public static synchronized SingletonExample4 getInstance(){
        if(instance == null ){//双重检测机制
            synchronized (SingletonExample4.class) {//同步锁
                if(instance == null ) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
