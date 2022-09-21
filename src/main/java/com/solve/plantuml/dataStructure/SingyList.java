package com.solve.plantuml.dataStructure;

/**
 * 数组实现单链表
 *
 * @author 吴欧(欧弟)
 */
public class SingyList {

    /**
     * 当前头节点
     */
    public static int head;

    /**
     * 链表值
     */
    static int [] e = new int[5];

    /**
     * 值的下一指针
     */
    static int [] ne = new int[5];

    /**
     * 当前可用节点
     */
    static int idx;
    
    public static void init() {
        head = -1;
        idx = 0;
    }

    /**
     * 插入头节点
     *
     * @param request 头节点
     */
    public static void addToHead(int request) {
        e[idx] = request;
        ne[idx] = head;
        head = idx;
        idx ++;
    }

    public static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx ++;
    }

    public static void delete(int k) {
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) {
        init();
        addToHead(10);
        addToHead(28);
        addToHead(36);
        addToHead(77);
    }
}
