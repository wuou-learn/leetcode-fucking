//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1092 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 被围绕的区域
 * @author wuou
 * @date 2024-03-04 11:25:12
 */
class P130_SurroundedRegions{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P130_SurroundedRegions().new Solution();
        solution.solve(new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int [] dx = new int[]{1,-1,0,0};
    int [] dy = new int[]{0,0,1,-1};
    int [][] cache;
    public void solve(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        cache = new int[x][y];

        for (int i = 0; i < x; i++) {
            if (board[i][0] == 'O') {
                dfs(i,0,board);
            }
            if (board[i][y-1] == 'O') {
                dfs(i,y-1,board);
            }
        }
        for (int j = 0; j < y; j++) {
            if (board[0][j] == 'O') {
                dfs(0,j,board);
            }
            if (board[x-1][j] == 'O') {
                dfs(x-1,j,board);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (cache[i][j] != 0) {
                    continue;
                }
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int x, int y, char[][] board) {
        cache[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'O' && cache[nx][ny] == 0) {
                dfs(nx,ny,board);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}