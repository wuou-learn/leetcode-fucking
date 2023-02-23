package com.solve.acwing;

import sun.nio.ch.sctp.SctpNet;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 并查集
 * <p>
 * 不相交际数据结构
 *
 * @author 吴欧(欧弟)
 */
public class Acwing09 {

    static int N = 100010;
    static int [] p = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m-- != 0) {
            String next = scanner.next();
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            switch (next) {
                case "M":
                    union(i,j);
                    break;
                case "Q":
                    int a = find(i);
                    int b = find(j);
                    if (a == b) {
                        System.out.println("Yes");
                    }else {
                        System.out.println("No");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootA] = rootB;
        }
    }

}
