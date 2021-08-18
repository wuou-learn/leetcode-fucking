package com.solve.单链表;

/**
 * @Description 静态链表
 * @Author wuou
 * @Date 2021/8/16 下午2:16
 * @Version 1.0.0
 */
public class StaticLinkedList {

    // 储存数据
    private int[] datas = new int[10];

    // 储存下一指针
    private int[] next = new int[10];

    // 当前空的指针
    private int idx = 0;

    // 链表头的索引位置
    private int head = 0;

    public void init(){
        idx = 0;
        head = 1;
    }

    /**
     * 插入头节点的位置
     * @param data
     */
    public void addToHead(int data){
        datas[idx] = data;
        next[idx] = head;
        head = idx;
        idx++;
    }

    /**
     * 插入index索引链表的后面
     * @param index
     * @param data
     */
    public void add(int index, int data){
        datas[idx] = data;
        next[idx] = next[index];
        next[index] = idx;
        idx++;
    }

    public void remove(int index){
        next[index] = next[next[index]];
    }

    public static void main(String[] args) {
        StaticLinkedList staticLinkedList = new StaticLinkedList();
        staticLinkedList.init();
        staticLinkedList.addToHead(8);
        staticLinkedList.add(1,10);
        staticLinkedList.remove(1);
    }

}
