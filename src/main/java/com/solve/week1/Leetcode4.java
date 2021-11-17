package com.solve.week1;

import java.util.*;

/**
 * @Description
 * @Author wuou
 * @Date 2021/11/17 下午3:23
 * @Version 1.0.0
 */
public class Leetcode4 {
    public static void main(String[] args) {
        Leetcode4 leetcode4 = new Leetcode4();

        leetcode4.findMedianSortedArrays2(new int[]{1,3},new int[]{2});
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length+nums2.length];

        for(int i =0; i<nums1.length; i++){
            res[i] = nums1[i];
        }
        for(int i =0; i<nums2.length; i++){
            res[nums1.length+i] = nums2[i];
        }
        Arrays.sort(res);
        if(res.length % 2 == 0){
            return (res[res.length/2]+res[(res.length/2)-1])/2.0;
        }else {
            return Double.valueOf(res[res.length/2]);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if ((n + m) % 2 == 1) {
            return find(nums1, 0, nums2, 0, (n + m) / 2 + 1);
        } else {
            int l = find(nums1, 0, nums2, 0, (n + m) / 2);
            int r = find(nums1, 0, nums2, 0, (n + m) / 2 + 1);
            return (l + r) / 2.0;
        }
    }

    public int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }
        if (i == nums1.length) {
            return nums2[j + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int si = Math.min(nums1.length, i + k / 2);
        int sj = j + k / 2;
        if (nums1[si - 1] > nums2[sj - 1]) {
            return find(nums1, i, nums2, sj, k - (sj - j));
        } else {
            return find(nums1, si, nums2, j, k - (si - i));
        }

    }

}
