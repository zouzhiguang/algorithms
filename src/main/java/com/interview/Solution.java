package com.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: Vincent
 * @since:1:29 PM, 24/9/2016
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int square = 0;
        int retang = 0;
        int others = 0;

        String line;
        while ((line = reader.readLine()) != null){
            if(line.isEmpty()) break;
            String[] split = line.trim().split(" ");
            int[] result = new int[4];
            for(int i = 0; i < 4; i++){
                result[i] = Integer.parseInt(split[i].trim());
            }
            if(result[0] == result[2] && result[1] == result[3]){
                if(result[0] == result[1]){
                    square++;
                }else {
                    retang++;
                }
            }else{
                others++;
            }
        }

        System.out.print("" + square + " " + retang + " " + others);

    }
}
