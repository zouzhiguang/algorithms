package com.interview.commons;

/**
 * @author: Vincent
 * @since:11:20 AM, 11/6/2016
 */
public class TestExecutionException extends RuntimeException {
    public TestExecutionException(Exception e) {
        super(e);
    }
}
