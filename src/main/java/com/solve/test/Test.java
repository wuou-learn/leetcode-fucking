package com.solve.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Wuou
 * @Date 2021-08-03 20:45
 * @Version V1.0
 **/
public class Test {

    public static void main(String[] args) {
        int [] a = new int[]{1,5,16,18,10};
        List<Integer> solve = solve(a);
        for (int b:solve) {
            System.out.println(b);
        }


    }

    /**
     * 写一段函数，参数是一个整数的列表
     * 找出列表里面满足下面列表的元素，该元素比放在他前面的所有元素都大
     */
    public static List<Integer> solve(int[] a){

        List<Integer> res = new ArrayList<>();

        for(int i = a.length-1; i>0; i--){

            int n = 0;
            for(int j =0; j<a.length-1; j++){
                n++;
                if(a[i]<a[j]){
                    break;
                }
                if(n==i){
                    res.add(a[i]);
                }

            }

        }
        return res;
    }

}
