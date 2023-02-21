package com.solve.acwing;

import java.util.Scanner;

/**
 * 826. 单链表
 *
 * @author 吴欧(欧弟)
 */
public class Acwing05 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] stk  = new int[100010];
        int tt = 0;

        for (int i = 0 ; i < n; i++) {
            // 待入栈元素
            int x = scan.nextInt();

            // 栈顶元素为最小元素,如果不是则弹出
            while (tt != 0 && x <= stk[tt]) {
                tt--;
            }

            // 如果栈内元素为空 则输出-1
            if (tt == 0) {
                System.out.print("-1 ");
            } else {
                System.out.print(stk[tt]+" ");
            }

            // 将x入栈
            stk[++tt] = x;
        }
    }

}
