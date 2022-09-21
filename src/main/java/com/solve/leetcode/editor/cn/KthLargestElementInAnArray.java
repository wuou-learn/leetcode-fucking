//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 1701, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quickSoft(0,nums.length-1,nums);
            return nums[nums.length-k];
        }

        public void quickSoft(int l, int r, int[] q) {
            if (l >= r) {
                return;
            }
            int x = q[l];
            int i = l - 1;
            int j = r + 1;
            while (i < j) {
                do {
                    i++;
                } while (q[i] < x);
                do {
                    j--;
                } while (q[j] > x);
                if (i < j) {
                    int temp = q[i];
                    q[i] = q[j];
                    q[j] = temp;
                }
            }
            quickSoft(l, j, q);
            quickSoft(j+1, r, q);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}