
public class _312_Burst_Balloons {
	public int maxCoins(int[] nums) {

		/*
		 * 	非常有意思的一道动态规划题
		 * 	i j 表示了开区间 （i，j）能得到的最多的硬币数
		 * 	
		 * 	状态值的计算中又添加了k值辅助计算
		 * 	即在数组 [ i, ..., k, ..., j]中
		 * 	假设最后戳破了气球k，则dp[i][j] = nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]
		 * 	所以这里需要求k在（i，j）区间内的所有可能，并取最大值
		 * 
		 * 	最后返回的值即为dp[0][n + 1]
		 * 
		 * 	在中间计算状态值的过程中，由于i和j之间差值更大的情况需要更小的值来辅助计算
		 * 	所以并不能按0->n这样的方式遍历
		 * 	1. 我的代码中写的是使用“长度” + “左节点” 枚举
		 * 	2. 还有一种方式是“i：n->0” + “j: i+1->n” 的方式进行枚举
		 * */
		
		int n = nums.length;
		int[][] dp = new int[n + 2][n + 2];

		// 创建一个数组用来包含原数组的边界值,在循环中免除多余的判断
		int[] val = new int[n + 2];
		val[0] = val[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
			val[i] = nums[i - 1];
		}

		for (int len = 1; len <= n + 2; len++) {
			for (int i = 0; i + len - 1 <= n + 1; i++) {
				int j = i + len - 1;
				if (len <= 2)
					dp[i][j] = 0;
				for (int k = i + 1; k < j; k++) {
					int coin = val[i] * val[k] * val[j];
					int sum = coin + dp[i][k] + dp[k][j];
					dp[i][j] = Math.max(dp[i][j], sum);
				}
			}
		}
		return dp[0][n + 1];
	}
}
