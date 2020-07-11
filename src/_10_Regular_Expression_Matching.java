
public class _10_Regular_Expression_Matching {
	public boolean isMatch(String s, String p) {
		
		/*
		 * 	����������O(n)ʱ��ı��������֤
		 * 	�ṹ������  "aa" ���� "ab*a" ������ֵ�ʽ�ӣ����Ծ͸�ǳ��
		 * 
		 * 	Ȼ��ŷ���������� ʵ���Ͽ�����״̬ת��ȥ��
		 * 	ԭ����ֱ�ӳ�����⣬�˼����д�ľ��Ǳ���д�ĺ�
		 * 	dp[i][j] ��ʾ s ��ǰ i���Ƿ��ܱ� p ��ǰj��ƥ��
		 * 	
		 * 	��� p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1]��
		 * 	��� p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]��
		 * 	��� p.charAt(j) == '*'��
		 * 		��� p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
		 * 		��� p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'��
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
