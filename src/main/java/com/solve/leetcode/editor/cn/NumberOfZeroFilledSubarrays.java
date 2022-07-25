//给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。 
//
// 子数组 是一个数组中一段连续非空元素组成的序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,0,0,2,0,0,4]
//输出：6
//解释：
//子数组 [0] 出现了 4 次。
//子数组 [0,0] 出现了 2 次。
//不存在长度大于 2 的全 0 子数组，所以我们返回 6 。 
//
// 示例 2： 
//
// 输入：nums = [0,0,0,2,0,0]
//输出：9
//解释：
//子数组 [0] 出现了 5 次。
//子数组 [0,0] 出现了 3 次。
//子数组 [0,0,0] 出现了 1 次。
//不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [2,10,2019]
//输出：0
//解释：没有全 0 子数组，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// 👍 2, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.*;

public class NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        Solution solution = new NumberOfZeroFilledSubarrays().new Solution();
        solution.zeroFilledSubarray(new int[] {0,0,0,0,1,0,0});
    }

    /**
     * 全 0 子数组的数目
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum != 0) {
                    sum = 0;
                    if (index != 0) {
                        list.add(index);
                        index = 0;
                    }
                } else {
                    index++;
                }
            }
            if (index != 0) {
                list.add(index);
            }

            long res = 0L;
            for (Integer j : list) {
                for (int i = 1; i <= j; i++) {
                    res += i;
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}