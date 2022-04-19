package com.solve.soft.quickSoft;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 吴欧(欧弟)
 */
public class Lc75 {

    public void sortColors(int[] nums) {
        quickSoft(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     *
     * @param nums 数组
     * @param l    左边界
     * @param r    右边界
     */
    public void quickSoft(int[] nums, int l, int r) {
        // 递归结束条件
        if (l >= r) {
            return;
        }

        int x = nums[l];
        int i = l - 1;
        int j = r + 1;

        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) {
                int tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
            }
        }

        quickSoft(nums,l, j);
        quickSoft(nums,j+1, r);
    }
}
