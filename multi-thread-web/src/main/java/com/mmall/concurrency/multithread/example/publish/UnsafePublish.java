package com.mmall.concurrency.multithread.publish;

import com.mmall.concurrency.multithread.annotion.NotRecommend;
import com.mmall.concurrency.multithread.annotion.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author baijianzhong
 * @ClassName UnsafePublish
 * @Date 2019-06-26 15:48
 * @Description TODO
 * 问题：发布线程以外的线程都能看到被发布线程发布过期的值
 **/
@Slf4j
@NotThreadSafe
@NotRecommend
public class UnsafePublish {

    private String[] states = { "a", " b", "c" };

    public String[] getStates(){
        return this.states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.states));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.states));
    }

}
