package com.solve.soft.快速排序;

/**
 * 快排-模板
 *
 * @author 吴欧(欧弟)
 */
public class Template {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 9, 20};
        quickSoft(arr, 0, arr.length - 1);
    }

    public static void quickSoft(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }

        int x = q[l];
        int i = l-1;
        int j = r+1;

        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);
            if(i < j){
                int tem = q[i];
                q[i] = q[j];
                q[j] = tem;
            }
        }
        quickSoft(q, l, j);
        quickSoft(q, j+1, r);
    }

}
