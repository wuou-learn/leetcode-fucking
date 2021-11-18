package com.solve.week1;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/17 下午3:23
 * @Version 1.0.0
 */
public class Leetcode9 {
    public static void main(String[] args) {
        Leetcode9 leetcode5 = new Leetcode9();

        System.out.println(leetcode5.isPalindrome(123));
    }

    public boolean isPalindrome(int x) {
        int t = 0;
        int temp = x;
        while(temp > 0){
            t = t*10 + temp%10;
            temp /= 10;
        }
        return t==x;
    }

}
