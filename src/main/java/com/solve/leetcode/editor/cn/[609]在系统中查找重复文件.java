package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindDuplicateFileInSystem {
    public static void main(String[] args) {
        Solution solution = new FindDuplicateFileInSystem().new Solution();
        solution.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"});
    }

    /**
     * 在系统中查找重复文件
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            // 文件内容  -  文件地址
            Map<String, List<String>> map = new HashMap<>();
            String address = "";
            String name = "";
            String content = "";
            for(String str : paths){
                String[] s = str.split(" ");
                address = s[0];
                for (int i = 1; i < s.length; i++) {
                    String[] split = s[i].split("\\(");
                    name = split[0];
                    content = split[1].substring(0, split[1].length()-1);
                    if (map.containsKey(content)) {
                        List<String> stringList = map.get(content);
                        stringList.add(address+"/"+name);
                    } else {
                        List<String> stringList = new ArrayList<>();
                        stringList.add(address+"/"+name);
                        map.put(content, stringList);
                    }
                }
            }
            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getValue().size() <= 1) {
                    continue;
                }
                res.add(entry.getValue());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
