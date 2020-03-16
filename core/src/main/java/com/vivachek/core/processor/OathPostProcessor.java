package com.vivachek.core.processor;

/**
 * @Description Oath的处理器
 * @Author CJB
 * @Date 2020/3/16 9:36
 */
public interface OathPostProcessor<T>{

    /**
     * 之前处理
     * @param t
     */
    default void beforeHandle(T t) {

    }

    /**
     * 之后处理
     * @param t
     */
    default void afterHandle(T t) {

    }
}