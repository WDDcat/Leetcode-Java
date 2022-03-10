package general_0000_0099;

public class _97_Interleaving_String {
	
	/*
	 * 	动态规划
	 * 	这个题的推导式不是很难
	 * 	
	 * 	但重点需要说明的是为什么不能使用双指针
	 * 	
	 * 	用这种方法判 s1=aabcc，s2=dbbca，s3=aadbbcbcac 时，得到的结果是 False，实际应该是 True
	 * 	*/
	
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();

		if (l1 + l2 != l3) {
			return false;
		}

		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		dp[0][0] = true;

		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				int p = i + j;
				if (i > 0) {
					dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p - 1));
				}
				if (j > 0) {
					dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p - 1));
				}
			}
		}
		return dp[l1][l2];
	}
}
