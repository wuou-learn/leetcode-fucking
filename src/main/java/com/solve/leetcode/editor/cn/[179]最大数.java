package com.solve.leetcode.editor.cn;

import java.util.*;

class LargestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer [] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(largestNumber(new int[]{arr[0], arr[1], arr[2]}));
    }

    public static String largestNumber(int[] nums) {
        String [] numsToWord = new String[3];
        for(int i=0;i<3;i++){
            numsToWord[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsToWord,(a,b)-> (b+a).compareTo(a+b));
        if("0".equals(numsToWord[0])){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++){
            sb.append(numsToWord[i]);
        }
        return sb.toString();
    }

}
