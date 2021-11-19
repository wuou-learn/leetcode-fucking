package com.solve.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/18 下午2:01
 * @Version 1.0.0
 */
public class LeetCode16 {
    public static void main(String[] args) {
        LeetCode16 leetCode11 = new LeetCode16();
        leetCode11.threeSumClosest(new int[]{-1,2,1,-4},1);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for(int i =0; i<nums.length; i++){
            int j = i+1;
            int k = nums.length-1;
            while (j < k ) {
                int cur = nums[i] + nums[j] + nums[k];
                if (cur == target) {
                    return target;
                }
                if(Math.abs(target-cur) < Math.abs(target-res)){
                    res = cur;
                    while(k>j && nums[k] == nums[k-1]){
                        k--;
                    }
                    while(k>j && nums[j] == nums[j+1]){
                        j++;
                    }
                }
                if (cur > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }

}
