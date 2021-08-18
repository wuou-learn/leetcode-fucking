package com.solve.soft;

import java.util.*;

/**
 * @Description 离散化
 * @Author wuou
 * @Date 2021/8/10 下午4:29
 * @Version 1.0.0
 */
public class Discrete {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(4);
        Collections.sort(list);
        for (int i : list){
            System.out.println(i);
        }
        System.out.println("我是分割线");
        Set<Integer> set = new HashSet<>(list);
        ArrayList<Integer> integers = new ArrayList<>(set);
        for (int i : integers){
            System.out.println(i);
        }
    }
}
