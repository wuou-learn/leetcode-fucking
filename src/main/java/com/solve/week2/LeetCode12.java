package com.solve.week2;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/18 下午2:01
 * @Version 1.0.0
 */
public class LeetCode12 {
    public static void main(String[] args) {
        LeetCode12 leetCode11 = new LeetCode12();
        leetCode11.intToRoman(2580);
    }

    public String intToRoman(int num) {
        String res = "";
        int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] reps = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for (int i = 12; i >= 0; i--) {
            while (num >= values[i]) {
                res += reps[i];
                num -= values[i];
            }
        }
        return res;
    }

}
