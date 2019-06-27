package com.mmall.concurrency.multithread.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * @author baijianzhong
 * @ClassName Escape
 * @Date 2019-06-26 16:15
 * @Description TODO
 *
 * 在对象未完成之前不可对其发布
 **/
@Slf4j
public class Escape {


    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass(){
            /**
             * this引用溢出
             */
            log.info("Escape  value :{}",Escape.this.thisCanBeEscape);
        }

    }

    public static void main(String[] args) {
        new Escape();
    }

}
