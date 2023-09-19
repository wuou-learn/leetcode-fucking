package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    /**
     * N 皇后
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int N = 20;
        boolean [] col = new boolean[N];
        boolean [] dg = new boolean[N];
        boolean [] udg = new boolean[N];
        char [][] path = new char[N][N];
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    path[i][j] = '.';
                }
            }
            dfs(0, n);
            return res;
        }

        private void dfs(int y, int n) {
            if (y == n) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        stringBuilder.append(path[i][j]);
                    }
                    list.add(stringBuilder.toString());
                }
                res.add(list);
            }
            for (int x = 0; x < n; x++) {
                if (!col[x] && !dg[x+y] && !udg[y-x+n]) {
                    path[x][y] = 'Q';
                    col[x] = dg[x+y] = udg[y-x+n] = true;
                    dfs(y+1, n);
                    path[x][y] = '.';
                    col[x] = dg[x+y] = udg[y-x+n] = false;
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
