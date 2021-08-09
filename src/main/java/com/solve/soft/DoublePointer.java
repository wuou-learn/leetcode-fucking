package com.solve.soft;

/**
 * 输入 abc def ghi
 * 输出 abc
 *     def
 *     ghi
 * @Description 双指针
 * @Author wuou
 * @Date 2021/8/9 下午3:05
 * @Version 1.0.0
 */
public class DoublePointer {

    public static void main(String[] args) {
//        pointer1(new String[]{"a","b","c"," ","g","h"," ","v","c"});
        System.out.println(point3(5,new int[]{1,2,2,2,3,5}));
    }

    /**
     * 双指针简单实现
     *
     * @param str
     */
    private static void pointer1(String[] str){
        int length = str.length;
        int j = 0;
        for(int i = 0; i<length; i++){
            while(j<length && !str[j].equals(" ")){
                j++;
            }
            String res ="";
            for(int a=i;a<j;a++){
                res=res+str[a];
            }
            System.out.println(res);
            i=j;
            j++;
        }
    }

    /**
     * 替换空格
     * @param str
     * @return
     */
    private static String pointer2(StringBuffer str){
        int length = str.length();
        int j = 0;
        String res = "";
        for(int i = 0; i<length; i++){
            if(str.charAt(i)==' '){
                res +="%20";
                continue;
            }
            res += String.valueOf(str.charAt(i));
        }
        return res;
    }

    /**
     * 给定一个长度为n的整数序列,请找出最长的不包含重复数字的连续子序列,输出它的长度
     * 输入:
     * 5
     * 1 2 2 3 5
     * 输出:
     * 3
     */
    private static int point3(int length, int[] arr){
        int j=1,res=1;
        for(int i =0; i<length; i++){
            if(j<=length && arr[i] != arr[j]){
                res+=1;
            }else{
                res=1;
            }
            j++;
        }

        return res;
    }

}
