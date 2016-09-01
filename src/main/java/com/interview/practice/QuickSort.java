package com.interview.practice;

import java.util.Arrays;

public class QuickSort {

     public void sort(int[] array){
         sort(array, 0, array.length - 1);
     }

     public int[] sort(int[] array, int begin, int end){
          if (begin <= end){
               int pivot = this.partition(array, begin, end);
               this.sort(array, begin, pivot - 1);
               this.sort(array, pivot + 1, end);
          }
          return array;
     }

     /**
      * The partition is the "one time" quick sort. The result makes sure:
      *   1) elements smaller than the pivot element are put on left side of pivot
      *   2) elements bigger than the pivot element are put on the right side of pivot
      * @param array The collection of elements under question
      * @param begin the start offset
      * @param end the end offset
      * @return The state of the quick sort, including the current array and the current pivot
      */
     private int partition(int[] array, int begin, int end){
        int i = begin - 1;
        int value = array[end];

        // At any given time, the for loop divides array[begin ... end] into 4 sections:
        //     1) array[begin .. i] the elements smaller or equal than array[end]
        //     2) array[i+1 .. j-1] the elements larger than array[end]
        //     3) array[j .. end-1] unrestricted elements
        //     4) array[end] the reference value
        for(int j = begin; j <= end; j++){
             if(array[j] <= value) {
                  i++;
                  this.switchElements(array, i, j);
             }
        }

          return i;
     }

     private void switchElements(int[] array, int i, int j) {
          int tmp = array[i];
          array[i] = array[j];
          array[j] = tmp;
     }

    public static void main(String... args)
    {
        QuickSort quickSort = new QuickSort();
        int[] test1 = {5, 4, 3, 2, 1};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {1, 1, 1, 1, 1};
        quickSort.sort(test1);
        quickSort.sort(test2);
        quickSort.sort(test3);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }
}
