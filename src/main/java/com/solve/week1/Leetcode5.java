package com.solve.week1;

import java.util.Arrays;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/17 下午3:23
 * @Version 1.0.0
 */
public class Leetcode5 {
    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();

        System.out.println(leetcode5.longestPalindrome("abba"));

    }

    public String longestPalindrome(String s) {
        String res = "";
        for(int i =0; i<s.length(); i++){
            // 奇数情况传入中点i
            String s1 = find(s,i,i);
            // 偶数情况传入中点i i+1
            String s2 = find(s,i,i+1);
            res = res.length()>s1.length()?res:s1;
            res = res.length()>s2.length()?res:s2;
        }
        return res;
    }

    public String find(String s,int l,int r){
        // 左右两边字符相等,继续找
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        // l--边界会=-1 所以要+1
        return s.substring(l+1,r);
    }

}
