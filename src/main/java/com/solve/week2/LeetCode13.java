package com.solve.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/18 下午2:01
 * @Version 1.0.0
 */
public class LeetCode13 {
    public static void main(String[] args) {
        LeetCode13 leetCode11 = new LeetCode13();
        leetCode11.romanToInt("MCMXCIV");
    }

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res =0;

        for(int i =0; i<s.length(); i++){
            if(i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res -= map.get(s.charAt(i));
            }else{
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

}
