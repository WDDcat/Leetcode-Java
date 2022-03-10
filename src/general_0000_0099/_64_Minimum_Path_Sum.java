package general_0000_0099;

public class _64_Minimum_Path_Sum {
	
	/*	单方向移动（仅右 & 仅下）的路径计算问题
	 * 	与王子从龙手里救公主那个很像
	 * 	比较简单的动态规划了
	 * 	现在已经能够得心应手
	 * */
	
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = grid[0][i] + dp[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
