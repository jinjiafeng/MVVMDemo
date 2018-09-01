package com.jjf.mvvm.util;

/**
 * @author :jinjiafeng
 * date:  on 18-8-31
 * description:
 */
public class CommonUtils {
    /**
     * 判断2个对象是否相等
     *
     * @param a Object a
     * @param b Object b
     * @return isEqual
     */
    public static boolean isEquals(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals(b);
    }
}
