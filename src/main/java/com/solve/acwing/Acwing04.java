package com.solve.acwing;

import java.util.Scanner;

/**
 * 826. 单链表
 *
 * @author 吴欧(欧弟)
 */
public class Acwing04 {

    public static int[] e = new int[100010];
    public static int[] ne = new int[100010];
    public static int idx;
    public static int head;

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        init();
        for (int i = 0; i < m; i++) {
            String n = scanner.next();
            switch (n) {
                case "H":
                    int h = scanner.nextInt();
                    addHead(h);
                    break;
                case "D":
                    int d = scanner.nextInt();
                    if(d == 0) {
                        head = ne[head];
                    }else {
                        delete(d-1);
                    }
                    break;
                case "I":
                    int k = scanner.nextInt();
                    int x = scanner.nextInt();
                    add(k-1,x);
                    break;
                default:
                    break;
            }
        }
        for(int i = head;i != -1;i = ne[i]){
            System.out.print(e[i] +  " ");
        }
    }

    public static void init() {
        head = -1;
        idx = 0;
    }

    /**
     * 将x插入第k个之后
     *
     * @param k 索引
     * @param x 值
     */
    public static void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    /**
     * 将x头插到第一位
     *
     * @param x 值
     */
    public static void addHead(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    /**
     * 将下标为k的后面的点删除
     *
     * @param k 索引
     */
    public static void delete(int k) {
        ne[k] = ne[ne[k]];
    }

}
