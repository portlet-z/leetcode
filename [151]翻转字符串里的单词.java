    //给定一个字符串，逐个翻转字符串中的每个单词。
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 295 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int dest = 0;
        boolean tag = false;
        boolean first = true;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == ' ') {
                if (!first) {
                    chars[dest] = ' ';
                }
                if (tag) {
                    dest++;
                    tag = false;
                }
            } else {
                first = false;
                tag = true;
                chars[dest++] = chars[i];
            }
        }
        if (chars[dest - 1] == ' ') {
            dest--;
        }
        reverse(chars, 0, dest - 1);
        int start = 0;
        for (int i=0; i<dest; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i-1);
                start = i + 1;
            }
        }
        reverse(chars, start, dest - 1);
        return new String(chars, 0, dest);
    }

    public void reverse(char[] chars, int start, int end) {
        for (int i=start; i<=(end + start)/2; i++) {
            char temp = chars[i];
            chars[i] = chars[end+start-i];
            chars[end+start-i] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
