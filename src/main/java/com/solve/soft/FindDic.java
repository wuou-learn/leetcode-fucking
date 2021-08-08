package com.solve.soft;


import java.util.Scanner;

/**
 * 整数二分模板
 */
public class FindDic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int num = scanner.nextInt();

        int[] arr = new int [length];
        for(int i=0; i<length; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<num; i++){
            solve(arr,scanner.nextInt());

        }

    }


    private static void solve(int[] arr, int target) {
        int l = 0, r = arr.length-1;

        while (l<r){
            int mid = l+r>>1;
            if(arr[mid] >= target){
                r=mid;
            }else{
                l=mid+1;
            }
        }

        if(arr[l]!=target){
            System.out.println("-1 -1");
            return;
        }else {
            System.out.print(l+" ");
        }

        l = 0;
        r = arr.length-1;

        while (l<r){
            int mid = l+r+1>>1;
            if(arr[mid] <= target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        System.out.println(r);
    }
}
