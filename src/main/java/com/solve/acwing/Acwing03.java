package com.solve.acwing;

import java.util.Scanner;

/**
 * TODO: Write something here..
 *
 * @author 吴欧(欧弟)
 */
public class Acwing03 {

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int res = 0;
        int [] s = new int[10010];
        for (int i = 0, j = 0; i < n; i++){
            s[a[i]]++;
            while (s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }
            res = Math.max(i-j+1, res);
        }
        System.out.println(res);
    }
}
