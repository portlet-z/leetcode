//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 817 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        dp[0][0] = grid[0][0];
        for (int a=1; a<i; a++) {
            dp[a][0] = grid[a][0] + dp[a-1][0];
        }
        for (int b=1; b<j; b++) {
            dp[0][b] = grid[0][b] + dp[0][b-1];
        }
        for (int a=1; a<i; a++) {
            for (int b=1; b<j; b++) {
                dp[a][b] = Math.min(dp[a-1][b], dp[a][b-1]) + grid[a][b];
            }
        }
        return dp[i-1][j-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
