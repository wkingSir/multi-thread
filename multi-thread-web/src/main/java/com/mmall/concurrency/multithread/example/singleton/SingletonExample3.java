package com.mmall.concurrency.multithread.example.singleton;

import com.mmall.concurrency.multithread.annotion.NotRecommend;
import com.mmall.concurrency.multithread.annotion.ThreadSafe;

/**
 * @author baijianzhong
 * @ClassName SingletonExample1
 * @Date 2019-06-26 16:30
 * @Description TODO
 *
 *  懒汉模式
 *
 **/
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null ){
            instance = new SingletonExample3();
        }
        return instance;
    }

}
