//设计一个数字容器系统，可以实现以下功能： 
//
// 
// 在系统中给定下标处 插入 或者 替换 一个数字。 
// 返回 系统中给定数字的最小下标。 
// 
//
// 请你实现一个 NumberContainers 类： 
//
// 
// NumberContainers() 初始化数字容器系统。 
// void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，
//那么用 number 替换该数字。 
// int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumberContainers", "find", "change", "change", "change", "change", "find", 
//"change", "find"]
//[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
//输出：
//[null, -1, null, null, null, null, 1, null, 2]
//
//解释：
//NumberContainers nc = new NumberContainers();
//nc.find(10); // 没有数字 10 ，所以返回 -1 。
//nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
//nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
//nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
//nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
//nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
//nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
//nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= index, number <= 10⁹ 
// 调用 change 和 find 的 总次数 不超过 10⁵ 次。 
// 
// 👍 2, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;
public class DesignANumberContainerSystem{
  public static void main(String[] args) {
//       Solution solution = new DesignANumberContainerSystem().new Solution();
  }
  /**
   * 设计数字容器系统
   */
  //leetcode submit region begin(Prohibit modification and deletion)
class NumberContainers {

    public NumberContainers() {

    }
    
    public void change(int index, int number) {

    }
    
    public int find(int number) {
        return 0;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
//leetcode submit region end(Prohibit modification and deletion)

}