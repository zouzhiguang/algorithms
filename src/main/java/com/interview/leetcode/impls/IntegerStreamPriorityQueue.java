package com.interview.leetcode.impls;

import com.interview.leetcode.IntegerStream;

import java.util.PriorityQueue;

public class IntegerStreamPriorityQueue implements IntegerStream {
     private PriorityQueue<Integer> queue;
     private int K;
     
     public IntegerStreamPriorityQueue(int K) {
         queue = new PriorityQueue<>(K + 2);
         this.K = K;
     }
     
    @Override
     public void write(int value) {
         // your solution here 
         queue.offer(value);
         if(queue.size() >  K){
             queue.poll();
         }
     }

     @Override
     public int get() {
         return queue.peek();
     }
}
