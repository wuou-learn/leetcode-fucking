package com.solve.soft.quickSoft;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 吴欧(欧弟)
 */
public class Lc215 {

    public int findKthLargest(int[] nums, int k) {
        quickSoft(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    /**
     * 快速排序模板
     * @param nums 数组
     * @param l 左索引
     * @param r 右索引
     */
    public void quickSoft(int[] nums, int l, int r){
        // 递归结束条件
        if(l >= r){
            return;
        }
        int x = nums[l];
        int i = l-1;
        int j = r+1;

        while(i < j){
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if(i < j) {
                int tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
            }
        }
        // 左排序
        quickSoft(nums,l,j);
        // 右排序
        quickSoft(nums,j+1,r);
    }

}
