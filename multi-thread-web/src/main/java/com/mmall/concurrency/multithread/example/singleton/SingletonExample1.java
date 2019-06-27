package com.mmall.concurrency.multithread.example.singleton;

import com.mmall.concurrency.multithread.annotion.NotThreadSafe;

/**
 * @author baijianzhong
 * @ClassName SingletonExample1
 * @Date 2019-06-26 16:30
 * @Description TODO
 *
 *  懒汉模式
 *
 **/
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){

    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null ){
            instance = new SingletonExample1();
        }
        return instance;
    }

}
