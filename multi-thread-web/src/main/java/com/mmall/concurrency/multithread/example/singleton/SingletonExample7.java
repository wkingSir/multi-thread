package com.mmall.concurrency.multithread.example.singleton;
//
//import com.mmall.concurrency.multithread.annotion.Recommend;
//import com.mmall.concurrency.multithread.annotion.ThreadSafe;

/**
 * @author baijianzhong
 * @ClassName SingletonExample1
 * @Date 2019-06-26 16:30
 * @Description TODO
 *
 *  枚举模式: 最安全的
 **/
//@ThreadSafe
//@Recommend
public class SingletonExample7 {

    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{

        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
