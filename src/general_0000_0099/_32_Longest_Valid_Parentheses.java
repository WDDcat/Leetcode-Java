package general_0000_0099;

public class _32_Longest_Valid_Parentheses {
	
	/*
	 * 	s[i] == '('
	 * 		dp[i] = 0
	 * 	s[i] == ')'
	 * 		s[i - 1] == '('
	 * 			dp[i] = dp[i - 2] + 2 
	 * 			要保证 i - 2 >= 0
	 * 
	 * 		s[i - 1] == ')' && s[i - dp[i - 1] - 1] == '('
	 * 			dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
	 * 			要保证i - dp[i - 1] - 2 >= 0
	 * */
	
	public int longestValidParentheses(String s) {
		int l = s.length();
		int[] dp = new int[l];
		int max = 0;

		for (int i = 1; i < l; i++) {
			if (s.charAt(i) == '(') {
				dp[i] = 0;
			} else { // ')'
				if (s.charAt(i - 1) == '(') {
					// 这里将dp赋值和相加拆开，是为了适应“()”这种情况
					dp[i] = 2;
					if (i - 2 >= 0) {
						dp[i] = dp[i - 2] + dp[i];
					}
				} else if (dp[i - 1] > 0 && (i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + 2;
					if (i - dp[i - 1] - 2 >= 0) {
						dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
