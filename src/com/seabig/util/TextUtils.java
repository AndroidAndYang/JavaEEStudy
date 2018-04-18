package com.seabig.util;

/**
 * @author: YJZ
 * data: 2018/4/18.
 * des: 判断字符是否为空
 */
public class TextUtils {

    public static boolean isEmpty(String str) {
        return str.trim().length() == 0 || "".equals(str.trim());
    }
}
