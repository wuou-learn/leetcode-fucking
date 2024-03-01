//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2428 👎 0


package com.solve.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayDeque;

/**
 * 岛屿数量
 *
 * @author wuou
 * @date 2024-02-29 21:25:35
 */
class P200_NumberOfIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P200_NumberOfIslands().new Solution();
        solution.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] g;
        int [] dx = new int[]{0,0,1,-1};
        int [] dy = new int[]{1,-1,0,0};
        ArrayDeque<Pair<Integer,Integer>> arrayDeque = new ArrayDeque<>();
        public int numIslands(char[][] grid) {
            g = grid;
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (g[i][j] == '1') {
                        bfs(i,j);
                        res ++;
                    }
                }
            }
            return res;
        }

        /*public void dfs(int i, int j) {
            g[i][j] = '0';
            for (int z = 0; z < 4; z++) {
                int x = dx[z] + i;
                int y = dy[z] + j;
                if (x >= 0 && x < g.length && y >= 0 && y < g[x].length && g[x][y] == '1') {
                    dfs(x,y);
                }
            }
        }*/

        public void bfs(int i, int j) {
            arrayDeque.offer(new Pair<>(i,j));
            while (!arrayDeque.isEmpty()) {
                Pair<Integer, Integer> poll = arrayDeque.poll();
                for (int z = 0; z < 4; z++) {
                    int a = poll.getKey() + dx[z];
                    int b = poll.getValue() + dy[z];
                    if (a >= 0 && a < g.length && b >= 0 && b < g[a].length && g[a][b] == '1') {
                        arrayDeque.offer(new Pair<>(a,b));
                        g[a][b] = '2';
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}