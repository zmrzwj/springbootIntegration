package com.sccddw.test.functions;

/**
 * description
 *
 * @author dell
 * date 2020/10/16 16:07
 * @version 1.0
 **/
@FunctionalInterface
public interface TestFun<T, R> {
    R add(T a, T b);
}
