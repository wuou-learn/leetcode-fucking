package com.solve.单链表;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/17 上午10:51
 * @Version 1.0.0
 */
public class Main {
    static int fact(int n) {
        int result = 0;
        if (n == 1) {
            return 1;
        }
        result = fact(n - 1) * n;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fact(4));

    }
}
