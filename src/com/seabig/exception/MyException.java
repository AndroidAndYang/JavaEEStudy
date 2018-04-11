package com.seabig.exception;

/**
 * @author: YJZ
 * data: 2018/4/11.
 * des: 自定义异常类
 */
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
