//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2604 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 移动零
 * @author wuou
 * @date 2025-03-26 17:18:20
 */
class P283_MoveZeroes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P283_MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{1,0});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx] = num;
                idx++;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}