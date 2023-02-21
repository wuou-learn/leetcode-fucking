package com.solve.acwing;

//有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
//
//    第 i 件物品的体积是 vi，价值是 wi。
//
//    求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
//    输出最大价值。
//
//    输入格式
//    第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
//
//    接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
//
//    输出格式
//    输出一个整数，表示最大价值。
//
//    数据范围
//    0<N,V≤1000
//    0<vi,wi≤1000
//    输入样例
//    4 5
//    1 2
//    2 4
//    3 4
//    4 5
//    输出样例：
//    8

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * TODO: Write something here..
 *
 * @author 吴欧(欧弟)
 */
public class Acwing01 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                if (true) {
                    throw new RuntimeException("test exception");
                }
                System.out.println(Thread.currentThread()+"主任务执行完成");
                return "res";
            } catch (Exception e) {
                System.out.println("exception");
                return null;
            }
        });

        future.thenAccept(res -> {
            System.out.println("主任务返回值:"+res);
        });
        future.thenAcceptAsync(res -> {
            if (res == null) {
                System.out.println("主任务异常子任务1 不执行");
                return;
            }
            System.out.println(Thread.currentThread()+"子任务1"+"------>"+"主任务返回值:"+res);
        });
        future.thenAcceptAsync(res -> {
            if (res == null) {
                System.out.println("主任务异常子任务2 不执行");
                return;
            }
            System.out.println(Thread.currentThread()+"子任务2"+"------>"+"主任务返回值:"+res);
        });
        future.thenAcceptAsync(res -> {
            if (res == null) {
                System.out.println("主任务异常子任务4 不执行");
                return;
            }
            System.out.println(Thread.currentThread()+"子任务4"+"------>"+"主任务返回值:"+res);
        });
        System.out.println("main wait");
        Thread.sleep(2000);
        System.out.println("main finish");
    }

}


