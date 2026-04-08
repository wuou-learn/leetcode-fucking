//一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。 
//
// 请你设计一个 TaskManager 类： 
//
// 
// TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, 
//priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。 
// void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 
//priority 的任务 taskId ，输入 保证 taskId 不在系统中。 
// void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入
// 保证 taskId 存在于系统中。 
// void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。 
// int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任
//务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。 
// 
//
// 注意 ，一个用户可能被安排多个任务。 
//
// 
//
// 示例 1： 
//
// 
// 输入： ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"] [[[[1,
// 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 1
//05, 15], []] 
// 
//
// 输出： [null, null, null, 3, null, null, 5] 
//
// 解释： TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3
//, 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。
// taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
// taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
// taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
// taskManager.rmv(101); // 将系统中的任务 101 删除。
// taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
// taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 10⁵ 
// 0 <= userId <= 10⁵ 
// 0 <= taskId <= 10⁵ 
// 0 <= priority <= 10⁹ 
// 0 <= newPriority <= 10⁹ 
// add ，edit ，rmv 和 execTop 的总操作次数 加起来 不超过 2 * 10⁵ 次。 
// 输入保证 taskId 是合法的。 
// 
//
// Related Topics 设计 哈希表 有序集合 堆（优先队列） 👍 10 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 设计任务管理器
 * @author wuou
 * @date 2025-09-18 09:57:26
 */
class P3408_DesignTaskManager{
    public static void main(String[] args) {
        //测试代码

    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class TaskManager {

    TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
    // key = priority value = List<task>
    Map<Integer, TreeSet<Integer>> priorityTaskHash = new HashMap<>();
    // key = task value = priority
    Map<Integer, Integer> taskPriorityHash = new HashMap<>();
    // key = task value = user
    Map<Integer, Integer> taskUserHash = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            Integer userId = task.get(0);
            Integer taskId = task.get(1);
            Integer priority = task.get(2);
            add(userId, taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        treeSet.add(priority);
        TreeSet<Integer> taskList = priorityTaskHash.getOrDefault(priority, new TreeSet<>());
        taskList.add(taskId);
        priorityTaskHash.put(priority, taskList);
        taskPriorityHash.put(taskId, priority);
        taskUserHash.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        Integer oriPriority = taskPriorityHash.get(taskId);
        if (oriPriority == null) return;

        TreeSet<Integer> oriTaskList = priorityTaskHash.get(oriPriority);
        if (oriTaskList.size() == 1 && oriTaskList.first().equals(taskId)) {
            priorityTaskHash.remove(oriPriority);
            treeSet.remove(oriPriority);
        } else {
            Object o = taskId;
            oriTaskList.remove(o);
        }

        taskPriorityHash.remove(taskId);
        treeSet.add(newPriority);
        TreeSet<Integer> taskList = priorityTaskHash.getOrDefault(newPriority, new TreeSet<>());
        taskList.add(taskId);
        priorityTaskHash.put(newPriority, taskList);
        taskPriorityHash.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        Integer oriPriority = taskPriorityHash.get(taskId);
        if (oriPriority == null) return;
        TreeSet<Integer> oriTaskList = priorityTaskHash.get(oriPriority);
        if (oriTaskList.size() == 1 && oriTaskList.first().equals(taskId)) {
            priorityTaskHash.remove(oriPriority);
            treeSet.remove(oriPriority);
        } else {
            Object o = taskId;
            oriTaskList.remove(o);
        }
        taskPriorityHash.remove(taskId);
        taskUserHash.remove(taskId);
    }
    
    public int execTop() {
        if (treeSet.isEmpty()) {
            return -1;
        }
        Integer priority = treeSet.first();
        TreeSet<Integer> list = priorityTaskHash.get(priority);
        int maxTask = list.last();
        Integer userId = taskUserHash.get(maxTask);
        rmv(maxTask);
        return userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
//leetcode submit region end(Prohibit modification and deletion)

}