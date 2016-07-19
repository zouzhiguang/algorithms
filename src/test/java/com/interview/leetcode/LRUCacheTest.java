package com.interview.leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author: vzou
 * *
 * @since: 6/23/2016.
 */
public class LRUCacheTest
{
    @Test
    public void testCanWork(){
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        Assert.assertEquals(lruCache.get(2), 1);
        lruCache.set(4,1);

        Assert.assertEquals(lruCache.get(2), -1);
        Assert.assertEquals(lruCache.get(4), 1);

    }
}
