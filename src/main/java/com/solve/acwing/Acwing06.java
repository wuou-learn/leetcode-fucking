package com.solve.acwing;

import java.io.*;

/**
 * @author 吴欧(欧弟)
 */
public class Acwing06 {

    static int N = 1000010;
    static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        String[] line1 = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        int[] a = new int[n];
        String[] line2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(line2[i]);
        int hh = 0;
        int tt = -1;
        for (int i = 0; i < n; i++) {
            // 如果队列中存在元素
            // 如果队列中元素超过k 弹出头节点
            if (hh <= tt && q[hh] < i-k+1) {
                hh++;
            }
            // 如果队列中存在元素
            // 尾插的节点小于尾节点
            while (hh <= tt && a[i] < a[q[tt]]) {
                tt--;
            }
            q[++tt] = i;
            if (i >= k-1) {
                printWriter.print(a[q[hh]]+" ");
            }
        }
        printWriter.println();
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            // 如果队列中存在元素
            // 如果队列中元素超过k 弹出头节点
            if (hh <= tt && q[hh] < i-k+1) {
                hh++;
            }
            // 如果队列中存在元素
            // 尾插的节点大于尾节点
            while (hh <= tt && a[i] > a[q[tt]]) {
                tt--;
            }
            q[++tt] = i;
            if (i >= k-1) {
                printWriter.print(a[q[hh]]+" ");
            }
        }
        printWriter.flush();
    }


}
