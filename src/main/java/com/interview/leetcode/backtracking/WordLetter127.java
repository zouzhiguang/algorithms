package com.interview.leetcode.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Vincent
 * @since:3:21 PM, 31/7/2016
 */
public class WordLetter127 {
    private Map<String, Set<String>> dict = new HashMap<>();
    private Map<String, Set<String>> records = new HashMap<>();
    private int result = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty() || beginWord.length() != endWord.length() || beginWord.isEmpty() || endWord.isEmpty()){
            return 0;
        }
        wordList.add(beginWord);
        wordList.add(endWord);
        makeWordsTable(wordList);

        Set<String> added = new HashSet<>();
        added.add(beginWord);

        foundSolution(beginWord, endWord, added, wordList);

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public boolean foundSolution(String currentWord, String endWord, Set<String> added, Set<String> wordList){
        if(currentWord.equals(endWord)){
            result = Math.min(result, added.size());
            return true;
        }

        //added.contains(currentWord) to prevent circling
        if(added.size() >= wordList.size() || dict.get(currentWord) == null) {
            return false;
        }

        for(String next : dict.get(currentWord)){
            if(added.contains(next) || (records.containsKey(currentWord) && records.get(currentWord).contains(next))){
                continue;
            }
            added.add(next);
            if(!foundSolution(next, endWord, added, wordList)){
                // from current to next, can not find a route.
                addToSet(next, currentWord, records);
            }

            added.remove(next);
        }

        return true;
    }
    // get all possible transmissions from availibles.
    public void makeWordsTable(Set<String> wordList){
        for(String s : wordList){
            for(String t : wordList){
                if(s == t || !oneLetterDiff(s, t)){
                    continue;
                }

                // only one letter is different
                addToSet(t, s, dict);
            }
        }
    }

    private void addToSet(String toAdded, String key, Map<String, Set<String>> map){
        Set<String> values = map.get(key);
        if(values == null){
            values = new HashSet<>();
            map.put(key, values);
        }

        values.add(toAdded);
    }

    public boolean oneLetterDiff(String a, String b){
        int diffCount = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(++diffCount > 1){
                    return false;
                }
            }
        }

        return diffCount != 0;
    }
}
