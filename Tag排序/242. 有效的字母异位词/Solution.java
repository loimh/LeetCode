package com.example.demo.service.impl;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Solution {
    public static  void main(String[] args){
        String s="zxcvbnm";
        String t="mnbvcxz";
        boolean f=isAnagram(s,t);
        System.out.println("是否是异位词："+f);
    }
    public static boolean isAnagram(String s, String t) {
        // 如果两个字符串的长度不相同时，直接返回false
        if(s.length()!=t.length()){
            return  false;
        }
        //初始化一个容量位26的数组，每个位置代表26个字母的位置
       int[] chars=new int[26];
        for(int i=0;i<s.length();i++){
            //两个字符串长度相同时，从第一个字符串第一位开始，数组中这个字符的代表位置+1
            chars[s.charAt(i)-'a']++;
            //第二个字符串，数组中的这个字符代表位置-1；
            chars[t.charAt(i)-'a']--;
        }
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
            //如果这个数组里面的元素都没有变，代表+1和-1相互抵消了，那么他们两个就是异位词，如果存在有1就表示不是异位词
            if(chars[i]==1) {
                return false;
            }
        }
        return  true;
    }
}
