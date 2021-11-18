package com.solve.week1;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/17 下午3:23
 * @Version 1.0.0
 */
public class Leetcode8 {
    public static void main(String[] args) {
        Leetcode8 leetcode5 = new Leetcode8();

        System.out.println(leetcode5.myAtoi("-42"));
    }

    public int myAtoi(String s) {
        int k = 0;
        while(k<s.length() && s.charAt(k)==' '){
            k++;
        }
        if(k==s.length()){
            return 0;
        }

        int minus = 1;
        if(s.charAt(k) == '-'){
            minus = -1;
            k++;
        }else if(s.charAt(k) == '+'){
            k++;
        }

        int res = 0;
        while(k<s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9'){
            int x = s.charAt(k) - '0';
            if(minus >0 && res > (Integer.MAX_VALUE-x)/10){
                return Integer.MAX_VALUE;
            }
            if(minus < 0 && -res < (Integer.MIN_VALUE+x)/10){
                return Integer.MIN_VALUE;
            }
            res = res *10 +x;
            k++;
        }

        return res*minus;
    }

}
