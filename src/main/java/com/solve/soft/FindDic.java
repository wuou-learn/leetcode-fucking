package com.solve.soft;


import java.util.Scanner;

/**
 * 整数二分模板
 */
public class FindDic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double l = -10000;
        double r = 10000;
        while (l < r) {
            double mid = (l + r)/2;
            if (mid*mid*mid >= x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.println(String.format("%.6f",l));
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


    /**
     * 浮点二分
     * @param x
     * @return
     */
    public static double dic(double x){

        double l =-10000.00,r=10000.00;

        for(int i =0; i<100; i++){
            double mid = (l+r)/2;
            if(mid*mid*mid >=x){
                r=mid;
            }else{
                l=mid;
            }
        }
        return l;
    }
}
