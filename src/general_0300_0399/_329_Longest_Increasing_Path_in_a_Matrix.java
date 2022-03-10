package general_0300_0399;

public class _329_Longest_Increasing_Path_in_a_Matrix {
	
	/*	
	 * 	�����Ͼ��Ƕ��������Ĭд
	 * 	
	 * 	������������Ƿǳ�ֱ�۵ķ�����
	 * 	��һ����Ԫ��ʼ����������������������ҵ��Ӹõ�Ԫ��ʼ�������·����
	 * 	��ÿ����Ԫ��ֱ���������������֮�󣬼��ɵõ������е������·���ĳ��ȡ�
	 * 
	 * 	�����������������ʱ�临�Ӷȹ��ߵ�ԭ���ǽ����˴������ظ����㣬ͬһ����Ԫ��ᱻ���ʶ�Σ�ÿ�η��ʶ�Ҫ���¼��㡣
	 * 	����ͬһ����Ԫ���Ӧ�������·���ĳ����ǹ̶�����ģ���˿���ʹ�ü��仯�ķ��������Ż���
	 * 	�þ���memo ��Ϊ��������Ѿ�������ĵ�Ԫ��Ľ���洢����������С�
	 * 	�����ʵ�һ����Ԫ�� (i,j) ʱ����� memo[i][j]��0��˵���õ�Ԫ��Ľ���Ѿ����������ֱ�Ӵӻ����ж�ȡ�����
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
