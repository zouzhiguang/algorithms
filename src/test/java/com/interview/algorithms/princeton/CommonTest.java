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

//    private static final ExecutorService executors = Executors.newSingleThreadExecutor();

//    protected <T> T executeAsyn(Duration timeout, Callable<T> task){
//        try {
//            return executors.submit(task).get(timeout.toMillis(), TimeUnit.MILLISECONDS);
//        } catch (TimeoutException e) {
//            throw new TimeExceedsException("Timeout reached for testing");
//        } catch (Exception e){
//            throw new TestExecutionException(e);
//        }
//    }
}
