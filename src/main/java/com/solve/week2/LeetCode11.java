package com.solve.week2;

import com.solve.单链表.LeetCode116;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/18 下午2:01
 * @Version 1.0.0
 */
public class LeetCode11 {
    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        leetCode11.maxArea(new int []{1,8,6,2,5,4,8,3,7});
    }

    public int maxArea(int[] height) {
        int res = 0;
        int l =0;
        int r = height.length;
        while(l < r){
            res = Math.max(res, Math.min(height[l],height[r]) * (r-l));
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }

}
