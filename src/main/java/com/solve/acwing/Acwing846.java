package com.solve.acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 树的重心
 */
public class Acwing846 {

    static int N = 200010;
    static int M = N * 2;
    static int [] h = new int[N];
    static int n = 0;
    static int [] e = new int[N];
    static int [] ne = new int[N];
    static boolean [] st = new boolean[N];
    static int idx = 0;
    static int ans = M;
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            add(b,a);
        }
        dfs(1);
        System.out.println(ans);
    }
    public static int dfs(int u) {
        // 将走过的点删除
        st[u] = true;
        // 默认算上自身
        int sum = 1, res = 0;
        // 遍历邻接表
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                // 递归他的邻接表上面所有能够抵达的点
                // 返回的数量是删除点下面的连通块的大小
                int s = dfs(j);
                // 拿到最大的连通块大小
                res = Math.max(res, s);
                // 每递归一个值就增加一个返回的s，将这个值作为最大的连通块大小
                sum += s;
            }
        }
        res = Math.max(res, n-sum);
        ans = Math.min(res,ans);
        return sum;
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
