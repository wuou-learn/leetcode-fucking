//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7109 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * 寻找两个正序数组的中位数
 * @author wuou
 * @date 2024-05-09 19:47:08
 */
class P4_MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        solution.findMedianSortedArrays(new int[]{100001}, new int[]{100000});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            // 如果为偶数 找到中间小的两位数/2 = 答案
            int left = find(nums1, 0,nums2, 0, total/2);
            int right = find(nums1, 0,nums2, 0, total/2+1);
            return (left+right)/2.0;
        } else {
            // 如果为奇数 找到中间的数 = 答案
            return find(nums1,0, nums2, 0, total/2+1);
        }
    }

    private int find(int[] nums1, int i, int[] nums2, int j, int k) {
        // 根据数组长度小的进行二分,从起始位置i，j开始算
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j,nums1, i, k);
        }
        // 如果第一个数组为空 则去第二个数组中找
        // 要么遍历完成，nums1 为空，则也去第二个数组中寻找
        if (nums1.length == i) {
            // nums2的数组是从j的索引开始的，要找到第k小的数，则第k小的数的索引=k-1
            return nums2[j + k - 1];
        }
        // 如果k=1 则取两个数组中的最小数
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        // k 是我们想找的第k小的数，k / 2表示我们想要在nums1中跳过的元素数量
        int si = Math.min(nums1.length, i + k / 2);
        // k是我们要找的第k小的数 k - k / 2表示我们想要在nums2中跳过的元素数量
        // 为什么是k - k / 2？因为在nums1中跳过了k / 2的数量 我们要保证找到第k小的数 所以在nums2中跳过k-k/2
        int sj = j + k - k / 2;
        if (nums1[si-1] > nums2[sj-1]) {
            return find(nums1,i,nums2,sj,k-(sj-j));
        } else {
            return find(nums1,si,nums2,j,k-(si-i));
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}