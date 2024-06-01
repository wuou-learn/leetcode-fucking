//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2440 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 下一个排列
 * @author wuou
 * @date 2024-03-08 15:24:15
 */
class P31_NextPermutation{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P31_NextPermutation().new Solution();
        solution.nextPermutation(new int[]{1,3,2});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void nextPermutation(int[] nums) {
        // 找到数列中最大值，并且开始降序的临界点
        int k = nums.length - 1;
        while (k > 0 && nums[k-1] >= nums[k]) {
            k--;
        }
        if (k <= 0) {
            reverse(nums,0,nums.length-1);
        } else {
            int t = k;
            while (t < nums.length && nums[t] > nums[k-1]) {
                t++;
            }
            swap(nums, k-1, t-1);
            reverse(nums,k,nums.length-1);
        }
    }

    public void reverse(int[] nums, int begin, int end) {
        for (;begin <= end && end >= 0; begin++, end--) {
            swap(nums, begin, end);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /* 暴力解 超时
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    boolean [] b;
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return ;
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        b = new boolean[nums.length];
        dfs(copy, 0);
        for (int m = 0; m < ans.size(); m++) {
            boolean flag = true;
            List<Integer> res = ans.get(m);
            for (int i = 0; i < nums.length; i++) {
                if (res.get(i) != nums[i]){
                    flag = false;
                }
            }
            if (flag) {
                if (m == ans.size() - 1) {
                    change(nums, ans.get(0));
                } else {
                    change(nums, ans.get(m+1));
                }
                return;
            }
        }
    }
    public void change(int[] nums, List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
    }
    public void dfs(int [] nums, int u) {
        if (u == nums.length && !set.contains(path.toString())) {
            ans.add(new ArrayList<>(path));
            set.add(path.toString());
        }
        for (int i = 0; i < nums.length; i++) {
            if (!b[i]) {
                b[i] = true;
                path.add(nums[i]);
                dfs(nums, u+1);
                b[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}