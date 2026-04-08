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

import java.util.ArrayDeque;
import java.util.Deque;

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

        int [] dx = new int[]{0, 1, 0, -1};
        int [] dy = new int[]{1, 0, -1, 0};
        public int numIslands(char[][] grid) {
            int x = grid.length;
            int y = grid[0].length;

            int count = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid, i, j, x, y);
                    }
                }
            }

            return count;
        }

        private void dfs(char[][] grid, int i, int j, int x, int y) {
            grid[i][j] = '0';
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + i;
                int ny = dy[d] + j;

                if (nx >= 0 && nx < x && ny >= 0 && ny < y && grid[nx][ny] == '1') {
                    dfs(grid, nx, ny, x, y);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}