package com.interview.algorithms.princeton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: vzou
 * *
 * @since: 5/9/2016.
 */
public abstract class CommonTest
{
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected abstract Object[][] prepareInstance();
}
