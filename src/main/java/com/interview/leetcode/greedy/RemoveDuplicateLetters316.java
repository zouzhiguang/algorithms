package com.interview.leetcode.greedy;

/**
 * @author: Vincent
 * @since:4:54 PM, 23/10/2016
 */
public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s) {
        StringBuilder builder = new StringBuilder();
        int hash = 0;
        for(int i = 0; i < s.length(); i++){
            if((hash & (1 << s.charAt(i) - 'a' )) > 0 && (hash & (0x7FFFFFFF >> (31 - s.charAt(i) + 'a'))) > 0){
                int index = builder.indexOf(s.substring(i, i+1));
                for(int j = builder.length() - 1; j >= 0; j--){
                    if(builder.charAt(j) < s.charAt(i)){
                        builder.deleteCharAt(index);
                        break;
                    }
                }
            }

            builder.append(s.charAt(i));
            hash |= 1 << (s.charAt(i) - 'a');
        }

        return builder.toString();
    }


    public boolean isMultiple(String s){
        if(s == null || s.length() <= 4) return false;
        int n = s.length();
        for(int i = 2; i <= n / 2; i++ ){
            if(n % i == 0 && checkSingle(s, n / i)) return true;

        }

        return false;
    }

    // check if s is replicated by s.substring(0, len)
    // complexity maximum is O(N)
    boolean checkSingle(String s, int len){
        if(s.length() % len != 0) return false;
        for(int i = 0; i < len; i++){
            for(int j = (s.length() / len) - 1; j > 0; j--){
                if(s.charAt(i) != s.charAt(i + j * len)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String... args){
        RemoveDuplicateLetters316 checker = new RemoveDuplicateLetters316();
        System.out.println(checker.isMultiple("abcabcabc"));   //true
        System.out.println(checker.isMultiple("bcdbcdbcde"));  //false
        System.out.println(checker.isMultiple("abcdabcd"));    //true
        System.out.println(checker.isMultiple("xyz"));         //false
        System.out.println(checker.isMultiple("aaaaaaaaaa"));  //true
        System.out.println(checker.isMultiple("bcdbcbcdbc"));  //true
        System.out.println(checker.isMultiple("aaaaaaa"));     //false
    }
}
