package com.mmall.concurrency.multithread.example.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author baijianzhong
 * @ClassName ImmutableExample1
 * @Date 2019-06-27 14:37
 * @Description TODO
 **/
public class ImmutableExample1 {

    private final static Integer a = 1;

    private final static String b = "2";

    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        //a = 2;

        //map = new HashMap<>();
    }

    private void test(final int a){
//        a = 1;
    }
}
