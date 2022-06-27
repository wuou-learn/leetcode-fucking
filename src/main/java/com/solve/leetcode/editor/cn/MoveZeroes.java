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
// Related Topics数组 | 双指针 
//
// 👍 1631, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{1,0,1});
    }

    /**
     * 283 移动零
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int s = 0;
            int f = 1;
            for (int i = 0; i < nums.length; i++) {
                if (f > nums.length-1) {
                    return;
                }
                if (nums[s] ==0 && nums[f] != 0) {
                    int tem = nums[s];
                    nums[s] = nums[f];
                    nums[f] = tem;
                    s++;
                    f++;
                } else if ((nums[s] !=0 && nums[f] != 0) || (nums[s] !=0 && nums[f] == 0)){
                    s++;
                    f++;
                } else if (nums[s] == 0 && nums[f] == 0){
                    f++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}