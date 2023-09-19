package com.solve.acwing;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 图中点的层次
 */
public class Acwing847 {

    static int N = 100010;
    static int [] h = new int[N];
    static int [] e = new int[N];
    static int [] ne = new int[N];
    static int idx = 0;
    static int [] d = new int[N];
    static int n = 0;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h,-1);
        Arrays.fill(d,-1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        // 第一个点的距离为0
        d[1] = 0;
        // 将第一个点入队列
        arrayDeque.offer(1);
        while (!arrayDeque.isEmpty()) {
            // 弹出队头
            int t = arrayDeque.pop();
            // 遍历邻接表
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                // 判断当前点是否走过
                if (d[j] == -1) {
                    // 没有走过加入队列
                    arrayDeque.offer(j);
                    // 距离增加
                    d[j] = d[t] + 1;
                }
            }
        }
        return d[n];
    }
    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
