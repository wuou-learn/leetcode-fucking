//给你一个整数 n 和一个二维整数数组 queries。 
//
// 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。 
//
// queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最
//短路径的长度。 
//
// 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，
//从城市 0 到城市 n - 1 的最短路径的长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]] 
// 
//
// 输出： [3, 2, 1] 
//
// 解释： 
//
// 
//
// 新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。 
//
// 
//
// 新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。 
//
// 
//
// 新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。 
//
// 示例 2： 
//
// 
// 输入： n = 4, queries = [[0, 3], [0, 2]] 
// 
//
// 输出： [1, 1] 
//
// 解释： 
//
// 
//
// 新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。 
//
// 
//
// 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 500 
// 1 <= queries.length <= 500 
// queries[i].length == 2 
// 0 <= queries[i][0] < queries[i][1] < n 
// 1 < queries[i][1] - queries[i][0] 
// 查询中没有重复的道路。 
// 
//
// Related Topics 广度优先搜索 图 数组 👍 7 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;


/**
 * 新增道路查询后的最短距离 I
 * @author wuou
 * @date 2024-08-10 21:04:45
 */
class P3243_ShortestDistanceAfterRoadAdditionQueriesI{
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P3243_ShortestDistanceAfterRoadAdditionQueriesI().new Solution();
//        solution.shortestDistanceAfterQueries(6, new int[][]{{2,4}});
    }
    static int ans = 0;
    public static int countGoodNodes(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.get(edges[i][0]) != null) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], null);
            }
        }
        Map<Integer,Integer> nodeSize = new HashMap<>();
        dfs(map, 0, nodeSize);
        return ans;
    }
    public static int dfs(Map<Integer, List<Integer>> map, int root, Map<Integer, Integer> nodeSize){
        if (map.get(root) == null) {
            return 1;
        }
        for (Integer node : map.get(root)) {
            int childSize = dfs(map, node, nodeSize);
            nodeSize.put(root, nodeSize.getOrDefault(node, 0)+childSize);
        }
        return 0;
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            List<List<Integer>> g = new ArrayList(n-1);
            for (int i = 0; i < n - 1; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i+1);
                g.add(list);
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                g.get(queries[i][0]).add(queries[i][1]);
                ans[i] = bfs(n, g);
            }
            return ans;
        }

        private int bfs(int n, List<List<Integer>> g) {
            int [] dist = new int[n];
            Arrays.fill(dist, -1);
            dist[0] = 0;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll == n - 1) {
                    return dist[n-1];
                }
                List<Integer> list = g.get(poll);
                for (Integer i : list) {
                    if (dist[i] != -1) {
                        continue;
                    }
                    dist[i] = dist[poll] + 1;
                    queue.offer(i);
                }
            }
            return dist[n-1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}