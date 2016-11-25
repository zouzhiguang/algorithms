package com.interview.leetcode.dp;

public class FairPainter
{
    /**
     * You have to paint N boards of length {A0, A1, A2 … AN-1}.
     * There are K painters available (they are in the same speed to paint the house).
     * You have to get this job done as soon as possible under the constraints that any painter will only paint continuous sections of board,
     * say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
     *
     * @param boards board array
     * @param k number of painters
     * @return minimum unit of time required.
     */
    public static int painter(int[] boards, int k)
    {
        if(k <= 0){
            return -1;
        }

        if(boards == null || boards.length <= k){
            return max(boards, 0, k - 1);
        }
        int[] partitions = new int[k];
        System.arraycopy(boards, 0, partitions, 0, k);

        for(int i = k ; i < boards.length; i++){
//            min(partitions, )
        }

        return partitions[boards.length - k - 1];
    }

    private static int min(int[] boards, int start, int end)
    {
        int min = start;
        for(int i = start; i<= end; i++) {
            if(boards[i] < boards[min]){
                min = i;
            }
        }
        return min;
    }

    private static int max(int[] boards, int start, int end)
    {
        int max = 0;
        for(int i = start; i<= end; i++) max = Math.max(max, boards[i]);
        return max;
    }

    public static void main(String... args){
        FairPainter painter = new FairPainter();
        System.out.println("" + (painter instanceof  FairPainter && true));

    }

}
