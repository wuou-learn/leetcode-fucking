package com.solve.soft;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 获取输入值
        int n = in.nextInt();   // 数组大小
        int count = in.nextInt();  // 查询个数

        // 获取完整数组
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        // 查询 count轮
        while (count-- != 0) {
            int target = in.nextInt();  // 本轮查询的目标值

            // 初始化 l和 r, 查找左边界
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (arr[mid] >= target) // 如果 mid满足, 需要向左寻找
                    r = mid;
                else
                    l = mid + 1;
            }
            // 跳出循环时, l == r, 如果数组中不存在 target
            if (arr[l] != target) {
                System.out.println("-1 -1");
            } else {
                System.out.print(l + " ");  // 注意输出值为下标
                // 初始化 l和 r, 查找右边界
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;   // 使用第二个模板
                    if (arr[mid] <= target) // 如果 mid满足, 需要向右寻找
                        l = mid;
                    else
                        r = mid - 1;
                }
                System.out.println(l);
            }
        }
    }
}
