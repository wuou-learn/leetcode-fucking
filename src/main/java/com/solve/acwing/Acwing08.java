package com.solve.acwing;

import java.io.*;

/**
 * Trie
 *
 * @author 吴欧(欧弟)
 */
public class Acwing08 {


    public static void main(String[] args) {
    }

    static int N = 100010;

    static int [][] son = new int[N][26];
    /**
     * 以某个单词结尾的打标
     */
    static int [] cnt = new int[N];
    static int idx = 0;
    public static  void insert(char[] str){
        // 定义根节点为0
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = ++idx;
            }
            // 进入下一层
            p = son[p][u];
        }
        // 记录尾部单词节点
        cnt[p]++;
    }
    public static int query(char[] str){
        int p = 0;//从根节点开始，下标是0表示根节点，头结点
        for(int i = 0 ; i < str.length; i ++){
            int u = str[i] - 'a'; // 将字符串每个字符都转化成数字0-25
            //如果这个点上面没有标记，就说明没有存入过这个字符，所以返回0
            if(son[p][u] == 0) return 0;
            //如果这个点上面能寻找到这个字符，就让他往下一层继续寻找；
            p = son[p][u];
        }
        //最后查找完之后输出最后一个做标记的点为下标的cnt数组的值。
        return cnt[p];
    }
}
