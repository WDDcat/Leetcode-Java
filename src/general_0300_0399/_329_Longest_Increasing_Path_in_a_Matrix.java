package general_0300_0399;

public class _329_Longest_Increasing_Path_in_a_Matrix {
	
	/*	
	 * 	基本上就是读完了题解默写
	 * 	
	 * 	深度优先搜索是非常直观的方法。
	 * 	从一个单元格开始进行深度优先搜索，即可找到从该单元格开始的最长递增路径。
	 * 	对每个单元格分别进行深度优先搜索之后，即可得到矩阵中的最长递增路径的长度。
	 * 
	 * 	朴素深度优先搜索的时间复杂度过高的原因是进行了大量的重复计算，同一个单元格会被访问多次，每次访问都要重新计算。
	 * 	由于同一个单元格对应的最长递增路径的长度是固定不变的，因此可以使用记忆化的方法进行优化。
	 * 	用矩阵memo 作为缓存矩阵，已经计算过的单元格的结果存储到缓存矩阵中。
	 * 	当访问到一个单元格 (i,j) 时，如果 memo[i][j]≠0，说明该单元格的结果已经计算过，则直接从缓存中读取结果。
	 * */
	
	private int row, col;

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) {
			return 0;
		}

		row = matrix.length;
		col = matrix[0].length;

		int[][] memo = new int[row][col];
		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ans = Math.max(ans, dfs(matrix, i, j, memo));
			}
		}
		return ans;
	}

	private int dfs(int[][] matrix, int i, int j, int[][] memo) {
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		memo[i][j]++;
		if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
			memo[i][j] = Math.max(memo[i][j], dfs(matrix, i - 1, j, memo) + 1);
		}
		if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
			memo[i][j] = Math.max(memo[i][j], dfs(matrix, i, j - 1, memo) + 1);
		}
		if (i + 1 < row && matrix[i + 1][j] < matrix[i][j]) {
			memo[i][j] = Math.max(memo[i][j], dfs(matrix, i + 1, j, memo) + 1);
		}
		if (j + 1 < col && matrix[i][j + 1] < matrix[i][j]) {
			memo[i][j] = Math.max(memo[i][j], dfs(matrix, i, j + 1, memo) + 1);
		}

		return memo[i][j];
	}
}
