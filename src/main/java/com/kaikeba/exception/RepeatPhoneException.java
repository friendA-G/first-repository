package com.kaikeba.exception;

/**
 * @Author: Gyx
 * @Date: 2021/2/27 15:55
 */
public class RepeatPhoneException extends Exception {
    public RepeatPhoneException() {
    }

    public RepeatPhoneException(String message) {
        super(message);
    }
}
