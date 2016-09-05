package com.interview.data.struture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter
{
    static class Tweet
    {
        static long sequence = 0L;
        int  tweetId;
        long seq;
        private Tweet next;

        public Tweet(int tweetId)
        {
            this.tweetId = tweetId;
            seq = ++sequence;
        }
    }

    // own history
    private Map<Integer, Tweet>        tweets;
    private Map<Integer, Set<Integer>> connections;
    private PriorityQueue<Tweet>       latest;

    /**
     * Initialize your data structure here.
     */
    public Twitter()
    {
        tweets = new HashMap<>();
        connections = new HashMap<>();
        latest = new PriorityQueue<>(10, (t1, t2) -> Long.compare(t2.seq, t1.seq));
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId)
    {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId)
    {
        latest.clear();

        Set<Integer> followees = new HashSet<>();
        followees.add(userId);
        Set<Integer> connection = connections.get(userId);
        if (connection != null)
        {
            followees.addAll(connection);
        }

        for (int friendId : followees)
        {
            Tweet tweet = tweets.get(friendId);
            if (tweet != null)
            {
                latest.add(tweet);
            }
        }
        List<Integer> latest10 = new ArrayList<>(10);
        while (latest10.size() < 10 && !latest.isEmpty())
        {
            Tweet tweet = this.latest.poll();
            latest10.add(tweet.tweetId);
            if (tweet.next != null)
            {
                latest.add(tweet.next);
            }
        }

        return latest10;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId)
    {
        Set<Integer> connection = connections.get(followerId);
        if (connection == null)
        {
            connection = new HashSet<>();
            connections.put(followerId, connection);
        }

        connection.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId)
    {
        Set<Integer> connection = connections.get(followerId);
        if (connection != null)
        {
            connection.remove(followeeId);
        }
    }

    public static void main(String... args)
    {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
