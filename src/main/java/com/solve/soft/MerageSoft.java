package com.solve.soft;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/5 下午2:14
 * @Version 1.0.0
 */
public class MerageSoft {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        mergeSoft(array, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void mergeSoft(int[] array, int l, int r) {
        // 判断边界值
        if(l >= r){
            return;
        }

        int mid = l + r >> 1;
        // 分组
        mergeSoft(array,l,mid);
        mergeSoft(array,mid+1,r);

        int [] res = new int [r-l+1];
        int k =0;
        int i =l;
        int j =mid+1;
        // 归并
        while (i<= mid && j<=r ){
            if(array[i] <= array[j]){
                res[k++] = array[i++];
            }else{
                res[k++] = array[j++];
            }
        }
        while (i<=mid){
            res[k++] = array[i++];
        }
        while(j<=r){
            res[k++] = array[j++];
        }

        for(i = l,j=0;i<=r;i++,j++){
            array[i] = res[j];
        }
    }
}
