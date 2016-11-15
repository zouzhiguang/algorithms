package com.interview.algorithms.data.structures;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.interview.algorithms.data.structures.impls.LinkedListQueue;
import com.interview.algorithms.data.structures.impls.ResizingArrayQueue;
import com.interview.algorithms.princeton.CommonTest;

/**
 * @author: Vincent
 * @since:10:27 AM, 10/5/16
 */
public class QueueTest extends CommonTest
{

    @Test(dataProvider = "prepareInstance")
    public void testQueue(String description, Queue<String> queue) throws Exception {
        logger.debug(description);

        Assert.assertTrue(queue.isEmpty());

        queue.enqueue("FIFO ");
        queue.enqueue("Queue ");
        queue.enqueue("implementation ");
        queue.enqueue("test ");
        queue.enqueue("success. ");
        queue.enqueue("Vincent ");
        queue.enqueue("you ");
        queue.enqueue("are ");
        queue.enqueue("brilliant");

        // should trigger the resizing.
        Assert.assertFalse(queue.isEmpty());
        Assert.assertTrue(queue.size() == 9);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(queue.dequeue());
        }

        Assert.assertEquals(sb.toString(), "FIFO Queue implementation test success. Vincent you are brilliant");

    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][] {
            {"FIFO Queue, Linked List implementation", new LinkedListQueue<String>()},
            {"FIFO Queue, Resizing array implementation", new ResizingArrayQueue<String>()},
        };
    }
}
