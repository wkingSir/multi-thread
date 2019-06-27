package com.mmall.concurrency.multithread.example.singleton;

import com.mmall.concurrency.multithread.annotion.ThreadSafe;

/**
 * @author baijianzhong
 * @ClassName SingletonExample1
 * @Date 2019-06-26 16:30
 * @Description TODO
 *
 *  饿汉模式
 *
 **/
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
