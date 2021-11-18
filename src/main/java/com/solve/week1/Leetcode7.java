package com.solve.week1;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/17 下午3:23
 * @Version 1.0.0
 */
public class Leetcode7 {
    public static void main(String[] args) {
        Leetcode7 leetcode5 = new Leetcode7();
        int x = 1534236469;

        System.out.println(leetcode5.reverse(x));
    }

    public int reverse(int x) {
        int res = 0;
        while (x!=0){
            if(x>0 && res>(Integer.MAX_VALUE-x%10)/10){
                return 0;
            }
            if(x<0 && res<(Integer.MIN_VALUE-x%10)/10){
                return 0;
            }
            res = res * 10 + x % 10;
            x/=10;
        }
        return res;
    }

}
