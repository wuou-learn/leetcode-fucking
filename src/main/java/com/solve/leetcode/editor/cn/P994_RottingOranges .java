//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 1138 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子
 * @author wuou
 * @date 2026-03-12 14:32:59
 */
class P994_RottingOranges{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P994_RottingOranges().new Solution();
        solution.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int [] dx = new int[]{0, 1, -1, 0};
    int [] dy = new int[]{1, 0, 0, -1};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();

        int x = grid.length;
        int y = grid[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i,j});
                }
            }
        }

        int ans = -1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int n = 0 ; n < size; n++) {
                int[] poll = deque.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    if (nx >= 0 && nx < x && ny >= 0 && ny < y && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
            ans ++;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans == -1 ? 0 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}