//package com.interview.leetcode.bitwise;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Pattern;
//
//public class WordDictionary {
//
//    class Trie{
//        Map<Character, Trie> tries;
//        boolean entry;
//        Trie(){
//            tries = new HashMap<>();
//            tries.values().stream().anyMatch(Trie::entry);
//        }
//        boolean entry(){ return entry;}
//    }
//    // Adds a word into the data structure.
//    public static void addWord(String word) {
//        Pattern compile = Pattern.compile("[+-]?(([0-9]+[\\.]?[0-9]*)|([0-9]*[\\.]?[0-9]+))(e[+-]?[0-9]+)?").matcher();
//        if(word == null || word.isEmpty()){
//            return;
//        }
//
//        for(int i = 0; i < word.length(); i++){
//            int hash = getHash(word.charAt(i));
//            if(hashTries.size() <= i)
//                hashTries.add(hash);
//            else
//                hashTries.set(i, hashTries.get(i) | hash);
//
//            if(i == word.length() - 1){
//                if(!entries.containsKey(i)) entries.put(i, hash);
//                else entries.put(i, entries.get(i) | hash);
//            }
//        }
//    }
//
//    private static int getHash(char c){
//        return c == '.' ? 0xFFFF : 1 << (c - 'a');
//    }
//
//    private static boolean isMatch(char c, int hash){
//        return c == '.' || (getHash(c) & hash) != 0;
//    }
//
//    // Returns if the word is in the data structure. A word could
//    // contain the dot character '.' to represent any one letter.
//    public static boolean search(String word) {
//        if(word == null) return false;
//        for(int i = 0; i < word.length(); i++) if(hashTries.size() <= i || !isMatch(word.charAt(i), hashTries.get(i))) return false;
//        return entries.get(word.length() - 1) != null && (entries.get(word.length() - 1) & getHash(word.charAt(word.length() - 1))) != 0;
//    }
//
//    public static void main(String... args) {
//        addWord("at");
//        addWord("and");
//        addWord("an");
//        addWord("add");
//        System.out.println(!search("a"));
//        System.out.println( !search(".at"));
//        addWord("bat");
//        System.out.println(search(".at"));
//        System.out.println(search("an."));
//        System.out.println(!search("a.d."));
//        System.out.println(!search("b."));
//        System.out.println(search("a.d"));
//        System.out.println(!search("."));
//        addWord("a");
//        System.out.println(search("."));
//
//        System.out.print("Success!");
//    }
//}
