package general_0000_0099;

public class _64_Minimum_Path_Sum {
	
	/*	�������ƶ������� & ���£���·����������
	 * 	�����Ӵ�������ȹ����Ǹ�����
	 * 	�Ƚϼ򵥵Ķ�̬�滮��
	 * 	�����Ѿ��ܹ�����Ӧ��
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
