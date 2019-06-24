package com.baijz.test.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author baijianzhong
 * @ClassName ThreadSafe
 * @Date 2019-06-24 20:30
 * @Description TODO 线程安全的类
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";

}
