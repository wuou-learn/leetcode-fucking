package com.solve.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/18 下午2:01
 * @Version 1.0.0
 */
public class LeetCode14 {
    public static void main(String[] args) {
        LeetCode14 leetCode11 = new LeetCode14();
        leetCode11.longestCommonPrefix(new String[]{"ab", "a"});
    }

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length == 0){
            return res;
        }

        for(int i=0; ; i++){
            if(i>= strs[0].length()){
                return res;
            }
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++ ){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return res;
                }
            }
            res += c;
        }
    }

}
