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
public class LeetCode15 {
    public static void main(String[] args) {
        LeetCode15 leetCode11 = new LeetCode15();
        leetCode11.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0; i<nums.length; i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                System.out.println("i:"+nums[i]+" j:"+nums[j]+" k:"+nums[k]+" sum="+sum);
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while(k>j && nums[k] == nums[k-1]){
                        k--;
                    }
                    while(k>j && nums[j] == nums[j+1]){
                        j++;
                    }
                }

                if(sum <= 0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }

}
