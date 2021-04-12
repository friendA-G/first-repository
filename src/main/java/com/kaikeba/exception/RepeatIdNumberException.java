package com.kaikeba.exception;

/**
 * @Author: Gyx
 * @Date: 2021/2/27 15:56
 */
public class RepeatIdNumberException extends Exception {
    public RepeatIdNumberException() {
    }

    public RepeatIdNumberException(String message) {
        super(message);
    }
}
