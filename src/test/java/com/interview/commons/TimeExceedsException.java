package com.interview.commons;

/**
 * @author: Vincent
 * @since:11:19 AM, 11/6/2016
 */
public class TimeExceedsException extends RuntimeException {
    public TimeExceedsException(String message) {
        super(message);
    }
}
