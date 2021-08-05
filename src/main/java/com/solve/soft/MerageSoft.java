package com.solve.soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/5 下午2:14
 * @Version 1.0.0
 */
public class MerageSoft {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bufferedReader.readLine();
        int n = Integer.parseInt(tmp);
        tmp = bufferedReader.readLine();

        int[] array = new int[n];
        String[] s = tmp.split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        mergeSoft(array, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
        bufferedReader.close();
    }

    private static void mergeSoft(int[] array, int l, int r) {

        int[] res = new int[array.length];

        if (l >= r) {
            return ;
        }

        int mid = l + r >> 1;
        mergeSoft(array, l, mid);
        mergeSoft(array, mid + 1, r);

        int k = 0;
        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {
            if (array[i] <= array[j]) {
                res[k++] = array[i++];
            } else {
                res[k++] = array[j++];
            }
        }

        while (i <= mid) {
            res[k++] = array[i++];
        }
        while (j <= r) {
            res[k++] = array[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            array[i] = res[j];
        }
    }
}
