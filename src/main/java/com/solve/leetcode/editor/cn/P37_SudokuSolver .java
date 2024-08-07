//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
// 
// 
//输入：board = [['5','3','.','.','7','.','.','.','.'],['6','.','.','1','9','5','.
//','.','.'],['.','9','8','.','.','.','.','6','.'],['8','.','.','.','6','.','.','.
//','3'],['4','.','.','8','.','3','.','.','1'],['7','.','.','.','2','.','.','.','6
//'],['.','6','.','.','.','.','2','8','.'],['.','.','.','4','1','9','.','.','5'],[
//'.','.','.','.','8','.','.','7','9']]
//输出：[['5','3','4','6','7','8','9','1','2'],['6','7','2','1','9','5','3','4','8
//'],['1','9','8','3','4','2','5','6','7'],['8','5','9','7','6','1','4','2','3'],[
//'4','2','6','8','5','3','7','9','1'],['7','1','3','9','2','4','8','5','6'],['9',
//'6','1','5','3','7','2','8','4'],['2','8','7','4','1','9','6','3','5'],['3','4',
//'5','2','8','6','1','7','9']]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// 
// 
// 
// 
//
//
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
//
// Related Topics 数组 哈希表 回溯 矩阵 👍 1827 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 解数独
 * @author wuou
 * @date 2024-06-05 09:06:47
 */
class P37_SudokuSolver{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P37_SudokuSolver().new Solution();
        solution.solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        boolean [][] row = new boolean[9][9];
        boolean [][] column = new boolean[9][9];
        boolean [][][] cell = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    row[i][t] = column[j][t] = cell[i/3][j/3][t] = true;
                }
            }
        }
        dfs(row,column,cell,board,0,0);
    }

    private boolean dfs(boolean[][] row, boolean[][] column, boolean[][][] cell, char[][] board, int x, int y) {
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') {
            return dfs(row,column,cell,board,x,y+1);
        }
        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !column[y][i] && !cell[x/3][y/3][i]) {
                board[x][y] = Character.forDigit(i+1, 10);
                row[x][i] = column[y][i] = cell[x/3][y/3][i] = true;
                if (dfs(row,column,cell,board,x,y+1)) {
                    return true;
                }
                board[x][y] = '.';
                row[x][i] = column[y][i] = cell[x/3][y/3][i] = false;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}