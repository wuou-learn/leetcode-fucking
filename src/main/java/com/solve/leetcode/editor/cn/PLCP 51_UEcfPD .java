//欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
//
//勇者背包内共有编号为 `0 ~ 4` 的五种食材，其中 `materials[j]` 表示第 `j` 种食材的数量。通过这些食材可以制作若干料理，`
//cookbooks[i][j]` 表示制作第 `i` 种料理需要第 `j` 种食材的数量，而 `attribute[i] = [x,y]` 表示第 `i` 道料理的美味
//度 `x` 和饱腹感 `y`。
//
//在饱腹感不小于 `limit` 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 `-1`。
//
//**注意：**
//- 每种料理只能制作一次。
//
//**示例 1：**
//
//> 输入：`materials = [3,2,4,1,2]`
//> `cookbooks = [[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]`
//> `attribute = [[3,2],[2,4],[7,6]]`
//> `limit = 5`
//>
//> 输出：`7`
//>
//> 解释：
//> 食材数量可以满足以下两种方案：
//> 方案一：制作料理 0 和料理 1，可获得饱腹感 2+4、美味度 3+2
//> 方案二：仅制作料理 2， 可饱腹感为 6、美味度为 7
//> 因此在满足饱腹感的要求下，可获得最高美味度 7
//
//**示例 2：**
//
//> 输入：`materials = [10,10,10,10,10]`
//> `cookbooks = [[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]]`
//> `attribute = [[5,5],[6,6],[10,10]]`
//> `limit = 1`
//>
//> 输出：`11`
//>
//> 解释：通过制作料理 0 和 1，可满足饱腹感，并获得最高美味度 11
//
//**提示：**
//+ `materials.length == 5`
//+ `1 <= cookbooks.length == attribute.length <= 8`
//+ `cookbooks[i].length == 5`
//+ `attribute[i].length == 2`
//+ `0 <= materials[i], cookbooks[i][j], attribute[i][j] <= 20`
//+ `1 <= limit <= 100`
//
// Related Topics 位运算 数组 回溯 枚举 👍 31 👎 0


package com.solve.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 烹饪料理
 * @author wuou
 * @date 2024-03-11 21:11:41
 */
class PLCP51_UEcfPD{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCP51_UEcfPD().new Solution();
        solution.perfectMenu(new int[]{10,10,10,10,10}, new int[][]{{1,1,1,1,1},{3,3,3,3,3},{10,10,10,10,10}}, new int[][]{{5,5},{6,6},{10,10}}, 1);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        dfs(cookbooks.length,0);
        // 方案
        int max = -1;
        for (List<Integer> an : ans) {
            Pair<Integer, Integer> calculate = calculate(an, cookbooks, materials, attribute);
            if (calculate == null) {
                continue;
            }
            // 饱腹感
            Integer value = calculate.getValue();
            if (value < limit) {
                continue;
            }
            max = Math.max(max, calculate.getKey());
        }
        return max;
    }
    public Pair<Integer,Integer> calculate(List<Integer> an, int[][] cookbooks, int[] materials, int[][] attribute) {
        int x = 0;
        int y = 0;
        int[] copy = Arrays.copyOf(materials, materials.length);
        for (int i = 0; i < an.size(); i++) {
            Integer idx = an.get(i);
            for (int b = 0; b < cookbooks[idx].length; b++) {
                if (cookbooks[idx][b] > materials[b] || cookbooks[idx][b] > copy[b]) {
                    return null;
                }
                copy[b] = copy[b] - cookbooks[idx][b];
            }
            x += attribute[idx][0];
            y += attribute[idx][1];
        }
        return new Pair<>(x,y);
    }
    public void dfs(int cookbooks, int u) {
        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = u; i < cookbooks; i++) {
            path.add(i);
            dfs(cookbooks, i+1);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}