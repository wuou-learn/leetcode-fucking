//电子表格是一个网格，它有 26 列（从 'A' 到 'Z'）和指定数量的 rows。每个单元格可以存储一个 0 到 10⁵ 之间的整数值。 
//
// 请你实现一个 Spreadsheet 类： 
//
// 
// Spreadsheet(int rows) 初始化一个具有 26 列（从 'A' 到 'Z'）和指定行数的电子表格。所有单元格最初的值都为 0 。 
// void setCell(String cell, int value) 设置指定单元格的值。单元格引用以 "AX" 的格式提供（例如，"A1"，"B10
//"），其中字母表示列（从 'A' 到 'Z'），数字表示从 1 开始的行号。 
// void resetCell(String cell) 重置指定单元格的值为 0 。 
// int getValue(String formula) 计算一个公式的值，格式为 "=X+Y"，其中 X 和 Y 要么 是单元格引用，要么非负整数，返回
//计算的和。 
// 
//
// 注意： 如果 getValue 引用一个未通过 setCell 明确设置的单元格，则该单元格的值默认为 0 。 
//
// 
//
// 示例 1： 
//
// 
// 输入： ["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue",
// "resetCell", "getValue"] [[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=
//A1+B2"], ["A1"], ["=A1+B2"]] 
// 
//
// 输出： [null, 12, null, 16, null, 25, null, 15] 
//
// 解释 Spreadsheet spreadsheet = new Spreadsheet(3); // 初始化一个具有 3 行和 26 列的电子表格
// spreadsheet.getValue("=5+7"); // 返回 12 (5+7)
// spreadsheet.setCell("A1", 10); // 设置 A1 为 10
// spreadsheet.getValue("=A1+6"); // 返回 16 (10+6)
// spreadsheet.setCell("B2", 15); // 设置 B2 为 15
// spreadsheet.getValue("=A1+B2"); // 返回 25 (10+15)
// spreadsheet.resetCell("A1"); // 重置 A1 为 0
// spreadsheet.getValue("=A1+B2"); // 返回 15 (0+15)
//
// 
//
// 提示： 
//
// 
// 1 <= rows <= 10³ 
// 0 <= value <= 10⁵ 
// 公式保证采用 "=X+Y" 格式，其中 X 和 Y 要么是有效的单元格引用，要么是小于等于 10⁵ 的 非负 整数。 
// 每个单元格引用由一个大写字母 'A' 到 'Z' 和一个介于 1 和 rows 之间的行号组成。 
// 总共 最多会对 setCell、resetCell 和 getValue 调用 10⁴ 次。 
// 
//
// Related Topics 设计 数组 哈希表 字符串 矩阵 👍 5 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计电子表格
 * @author wuou
 * @date 2025-09-19 09:59:36
 */
class P3484_DesignSpreadsheet{
    public static void main(String[] args) {
        //测试代码
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Spreadsheet {

    private List<int[]> values;

    public Spreadsheet(int rows) {
        values = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            values.add(new int[26]);
        }
    }

    // 设置单元格
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        values.get(pos[0])[pos[1]] = value;
    }

    // 重置单元格
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        values.get(pos[0])[pos[1]] = 0;
    }

    // 获取公式的值
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;
        for (String part : parts) {
            if (Character.isLetter(part.charAt(0))) { // 单元格
                int[] pos = parseCell(part);
                sum += values.get(pos[0])[pos[1]];
            } else { // 纯数字
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }

    // 工具方法：解析 "A1" → [row, col]
    private int[] parseCell(String cell) {
        String colStr = cell.substring(0, 1);
        String rowStr = cell.substring(1);
        int col = colStr.charAt(0) - 'A';
        int row = Integer.parseInt(rowStr) - 1;
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
//leetcode submit region end(Prohibit modification and deletion)

}