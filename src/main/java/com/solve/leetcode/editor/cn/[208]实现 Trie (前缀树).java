package com.solve.leetcode.editor.cn;

class ImplementTriePrefixTree {
    public static void main(String[] args) {
    }

    /**
     * 实现 Trie (前缀树)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        public Trie() {

        }

        int N = 31000;
        int[][] son = new int[N][26];
        int idx = 0;
        int[] cnt = new int[N];

        public void insert(String word) {
            char[] chars = word.toCharArray();
            int p = 0;
            for (int i = 0; i < chars.length; i++) {
                int u = chars[i] - 'a';
                // 如果当前字母没有分支，创建新的分支
                if (son[p][u] == 0) {
                    son[p][u] = ++idx;
                }
                // 遍历下层分支
                p = son[p][u];
            }
            // 当前尾部字母进行标记
            cnt[p]++;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            int p = 0;
            for (int i = 0; i < chars.length; i++) {
                int u = chars[i] - 'a';
                // 如果当前字母不存在
                if (son[p][u] == 0) {
                    return false;
                }
                // 遍历下层分支
                p = son[p][u];
            }
            if (cnt[p] != 0) {
                return true;
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            int p = 0;
            for (int i = 0; i < chars.length; i++) {
                int u = chars[i] - 'a';
                // 如果当前字母不存在
                if (son[p][u] == 0) {
                    return false;
                }
                // 遍历下层分支
                p = son[p][u];
            }
            return true;
        }

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
