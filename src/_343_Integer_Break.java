
public class _343_Integer_Break {
	public int integerBreak(int n) {
		
		/*
		 * 	相当于遍历一下分成 2,3...,n个数字的情况
		 * */
		
		int[] dp = new int[n + 1];
		for(int num = 2; num < n; num++) {
			int max = 0;
			for(int j = 1; j <= num; j++) {
				max = Math.max(max, Math.max(j * (num - j), j * dp[num - j]));
			}
			dp[num] = max;
		}
		return dp[n];
    }
}
