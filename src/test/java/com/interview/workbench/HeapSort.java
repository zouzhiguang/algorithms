package com.interview.workbench;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
	public void sort(int[] nums){
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int num : nums){
			queue.offer(num);
		}

		int counter = 0;
		while(!queue.isEmpty()){
			nums[counter++] = queue.poll();
		}
	}

	public static void main(String... args){
		HeapSort sort = new HeapSort();
		int[] nums = new int[]{3,5,1,2,6,9,0,7,4,8};
		sort.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}


