package com.readWriteSplit;

import java.lang.annotation.*;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:33 PM.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    public String name();
}
