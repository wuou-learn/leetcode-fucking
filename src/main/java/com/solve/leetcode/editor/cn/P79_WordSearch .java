//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1838 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 单词搜索
 * @author wuou
 * @date 2024-07-11 14:23:54
 */
class P79_WordSearch{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P79_WordSearch().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int [] dx = new int[]{-1,0,1,0};
    int [] dy = new int[]{0,1,0,-1};
    int a;
    int b;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i,j,board,word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int x, int y, char[][] board, String word, int u) {
        if (board[x][y] != word.charAt(u)) {
            return false;
        }
        if (u == word.length() - 1) {
            return true;
        }
        char t = board[x][y];
        board[x][y]='#';
        for (int i = 0; i < 4; i++) {
            a = x + dx[i];
            b = y + dy[i];
            if (a < 0 || b < 0 || a >= board.length || b >= board[0].length || board[a][b] == '#') {
                continue;
            }
            if (dfs(a, b, board, word, u+1)) {
                return true;
            }
        }
        board[x][y]=t;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}