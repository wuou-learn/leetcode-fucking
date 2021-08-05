package com.solve.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定你一个长度为 n 的整数数列。
 *
 * 请你使用快速排序对这个数列按照从小到大进行排序。
 *
 * 并将排好序的数列按顺序输出。
 *
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 *
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 *
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 *
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 * @Author wuou
 * @Date 2021/8/5 上午10:36
 * @Version 1.0.0
 */
public class QuickSoft785 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bufferedReader.readLine();
        int n = Integer.parseInt(tmp);
        tmp = bufferedReader.readLine();

        int [] array = new int[n];
        String[] s = tmp.split(" ");
        for(int i =0; i<n; i++){
            array[i] = Integer.parseInt(s[i]);
        }
        quickSoft(array,0,n-1);
        for(int i =0; i<n; i++){
            System.out.print(array[i]);
        }
        bufferedReader.close();
    }

    private static void quickSoft(int[] array, int l, int r) {

        if(l >= r){
            return ;
        }

        int x = array[l];
        int i = l-1;
        int j = r+1;

        while (i < j){
            do {
                i++;
            }while (array[i] < x);
            do {
                j--;
            }while (array[j] > x);

            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        quickSoft(array,l,j);
        quickSoft(array,j+1,r);
    }


}
