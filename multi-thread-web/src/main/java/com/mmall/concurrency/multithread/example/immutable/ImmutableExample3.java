package com.mmall.concurrency.multithread.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.multithread.annotion.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baijianzhong
 * @ClassName ImmutableExample1
 * @Date 2019-06-27 14:37
 * @Description TODO
 *
 * 被 unmodifiableXXX修饰过的集合，可以对其操作，但会抛出异常 UnsupportedOperationException
 *
 **/
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(1,2);

    }

    private void test(final int a){
//        a = 1;
    }
}
