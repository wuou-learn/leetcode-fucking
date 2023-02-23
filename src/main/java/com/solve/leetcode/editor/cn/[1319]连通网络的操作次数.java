package com.solve.leetcode.editor.cn;

class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        Solution solution = new NumberOfOperationsToMakeNetworkConnected().new Solution();
        solution.makeConnected(12, new int[][]{{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}});
    }

    /**
     * 连通网络的操作次数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 剩余连接电缆数
        int num;
        int [] p;
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n-1) {
                return -1;
            }
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
            num = n - 1;
            for (int i = 0; i < connections.length; i++) {
                union(connections[i][0],connections[i][1]);
            }
            return num;
        }


        public int query(int x) {
            if (p[x] != x) {
                p[x] = query(p[x]);
            }
            return p[x];
        }

        public void union(int a, int b) {
            int rootA = query(a);
            int rootB = query(b);
            if (rootA != rootB) {
                p[rootA] = rootB;
                num --;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
