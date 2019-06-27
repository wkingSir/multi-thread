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
public class SingletonExample6 {

    private static SingletonExample6 instance;

    //单例对象
    static {
        instance = new SingletonExample6();
    }

    //私有构造函数
    private SingletonExample6(){

    }

    //静态工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
