package com.solve.acwing;

import java.io.*;

/**
 * kmp
 *
 * @author 吴欧(欧弟)
 */
public class Acwing07 {

    static int N = 100010;
    static int[] next = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        String p = " "+bufferedReader.readLine();
        int m = Integer.parseInt(bufferedReader.readLine());
        String s = " "+bufferedReader.readLine();

        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();

        // 拿到最短匹配前后缀
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && pp[i] != pp[j+1]) {
                j = next[j];
            }
            if (pp[i] == pp[j+1]) {
                j++;
            }
            next[i] = j;
        }

        // kmp匹配
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && ss[i] != pp[j+1]) {
                j = next[j];
            }
            if (ss[i] == pp[j+1]) {
                j++;
            }
            if (j == n) {
                j = next[j];
                printWriter.print(i-n+" ");
            }
        }
        printWriter.flush();
    }


}
