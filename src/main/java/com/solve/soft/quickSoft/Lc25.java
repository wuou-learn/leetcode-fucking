package com.solve.soft.quickSoft;

/**
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 吴欧(欧弟)
 */
public class Lc25 {
    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3},3);
    }
    public static int removeElement(int[] c, int val) {
        int[] res = new int[c.length];
        for (int i = 0,j=0; i < c.length; i++) {
            if (c[i] == val) {
                continue;
            }
            res[j] = c[i];
            j++;
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] == 0) {
                break;
            }
            c[i] = res[i];
        }
        return res.length;
    }
}
