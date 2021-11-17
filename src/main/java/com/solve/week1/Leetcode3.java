package com.solve.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/17 下午3:23
 * @Version 1.0.0
 */
public class Leetcode3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcab");
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            }
            set.add(s.charAt(i));
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

}
