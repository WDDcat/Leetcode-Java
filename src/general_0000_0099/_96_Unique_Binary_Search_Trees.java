package general_0000_0099;

public class _96_Unique_Binary_Search_Trees {
	
	/*
	 * 	真·万物皆可动态规划
	 * 	按照 BST 的定义，如果整数 k去构建根节点，则整数 1 ~ k-1 会去构建左子树，k+1 ~ n 会去构建右子树
	 * 	以 k 为根节点的 BST 种类数 = 左子树BST的种类数 * 右子树BST的种类数
	 * 
	 * 	上面的暴力解法称之为“卡塔兰数”
	 * */
	
	public int numTrees(int n) {

//		int[] res = new int[] {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};
//		return res[n];
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}

		return dp[n];
	}
}
