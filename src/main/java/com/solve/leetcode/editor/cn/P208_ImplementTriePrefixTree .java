//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1926 👎 0


package com.solve.leetcode.editor.cn;

import com.sun.scenario.effect.impl.prism.PrDrawable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 实现 Trie (前缀树)
 * @author wuou
 * @date 2026-03-12 17:42:45
 */
class P208_ImplementTriePrefixTree{
    public static void main(String[] args) {
        //测试代码
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private Trie [] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Trie();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = searchPre(word);
        if (node == null) {
            return false;
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = searchPre(prefix);
        return node != null;
    }

    public Trie searchPre(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            Trie node = root.children[i];
            if (node == null) {
                return null;
            }
            root = node;
        }
        return root;
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