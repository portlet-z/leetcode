//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3407 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == "") {
            return "";
        }
        int start = 0;
        int end = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 2 && chars[0] == chars[1]) {
            return s;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[j]) {
                if (i - j > end - start) {
                    end = i;
                    start = j;
                }
            }
            if (i + 1 < chars.length && chars[i + 1] == chars[j]) {
                if (i + 1 - j > end - start) {
                    end = i + 1;
                    start = j;
                }
            } else {
                j++;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
