package com.baijz.test.annotions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author baijianzhong
 * @ClassName ThreadSafe
 * @Date 2019-06-24 20:30
 * @Description TODO 不推荐的写法
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {

    String value() default "";

}
