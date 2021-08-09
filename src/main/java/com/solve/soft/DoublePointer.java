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
        pointer1(new String[]{"a","b","c"," ","g","h"," ","v","c"});
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

}
