//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1622 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author wuou
 * @date 2024-05-16 20:08:35
 */
class P16_ThreeSumClosest{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P16_ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[]{-5,-5,-5,-1}, -14);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 双指针，必须有序
        Arrays.sort(nums);
        int res = 200010;
        int min = 200010;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                // i保持固定，j越大，需要越靠近target，则k越小
                // j 去重不能与k重复
                while (j < k - 1 && nums[i] + nums[j] + nums[k - 1] >= target) {
                    k--;
                }
                int ans = nums[i] + nums[j] + nums[k];
                int sub = Math.abs(ans - target);
                if (sub < min) {
                    min = sub;
                    res = ans;
                }
                // 计算左侧和小于target，记录最小数据 并且指针不重合
                if (k - 1 > j) {
                    ans = nums[i] + nums[j] + nums[k - 1];
                    sub = Math.abs(ans - target);
                    if (sub < min) {
                        min = sub;
                        res = ans;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}