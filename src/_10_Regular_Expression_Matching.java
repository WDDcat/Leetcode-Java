
public class _10_Regular_Expression_Matching {
	public boolean isMatch(String s, String p) {
		
		/*
		 * 	本来想做到O(n)时间的遍历完成验证
		 * 	结构发现了  "aa" 满足 "ab*a" 这样奇怪的式子，尝试就搁浅了
		 * 
		 * 	然后才发现了这个题 实际上可以用状态转移去做
		 * 	原谅我直接超了题解，人家这个写的就是比我写的好
		 * 	dp[i][j] 表示 s 的前 i个是否能被 p 的前j个匹配
		 * 	
		 * 	如果 p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1]；
		 * 	如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
		 * 	如果 p.charAt(j) == '*'：
		 * 		如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
		 * 		如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
		 * 			dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
		 * 			or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
		 * 			or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
		 * */
		
		if (s == null || p == null) {
			return false;
		}

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true; // here's y axis should be i+1
			}
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
					}
				}
			}
		}

		return dp[s.length()][p.length()];

//		for(int i = 0; i < s.length(); i++) {
//			System.out.println(s.substring(i, s.length()) + " -- " + p);
//			if(p.length() >= 2 && p.charAt(1) == '*') {
//				char c = p.charAt(0);
//				// .* -> true
//				if(c == '.' && p.length() == 2) return true;
//				
//				// a*a -> a*   ||   a*aa -> a*
//				if(p.length() >= 3 && p.charAt(2) == c) {
//					p = p.substring(2, p.length());
//					while(p.length() > 0 && p.charAt(0) == c) {
//						p = p.substring(1, p.length());
//					}
//					p = String.valueOf(c) + '*' + p;
//				}
//				if(i < s.length() && c == s.charAt(i)) {
//					while(i < s.length() && c == s.charAt(i)) {
//						i++;
//					}
//				}
//				i--;
//				p = p.substring(2, p.length());
//			}
//			else if(p.length() >= 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
//				p = p.substring(1, p.length());
//			}
//			else return false;
//		}
//		if(p.length() > 0) return false;
//		return true;
	}
}
