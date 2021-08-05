package com.solve.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * 给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 k。
 *
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整数数列。
 *
 * 输出格式
 * 输出一个整数，表示数列的第 k 小数。
 *
 * 数据范围
 * 1≤n≤100000,
 * 1≤k≤n
 * 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 * @Author wuou
 * @Date 2021/8/5 上午11:41
 * @Version 1.0.0
 */
public class QuickSoft786 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String[] s = str.split(" ");
        int length = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        str = bf.readLine();
        String [] array = str.split(" ");
        int [] arrays = new int[length];
        for(int i = 0; i<length; i++){
            arrays[i] = Integer.parseInt(array[i]);
        }

        quickSoft(arrays,0,length-1);

        System.out.print(arrays[n-1]);
    }

    private static void quickSoft(int[] arrays, int l, int r) {
        if(l >= r){
            return ;
        }
        int x = arrays[l];
        int i = l-1;
        int j = r+1;

        while (i<j){
            do{
                i++;
            }while (arrays[i]<x);
            do {
                j--;
            }while (arrays[j]>x);

            if( i < j ){
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
            }
        }
        quickSoft(arrays,l,j);
        quickSoft(arrays,j+1,r);
    }
}
