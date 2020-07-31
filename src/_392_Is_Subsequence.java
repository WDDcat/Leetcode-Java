
public class _392_Is_Subsequence {
	public boolean isSubsequence(String s, String t) {
		
		/*
		 * 	双指针，简单题
		 * 	和题解不同的是
		 * 	我这里在s指针满足条件后立即返回
		 * 	而题解需要便利t中的所有子字符
		 * 	在某些测试上会更省时吧
		 * */
		
		if (s.length() == 0 || t.length() == 0) {
			if (s.length() == 0)
				return true;
			else
				return false;
		}
		int ps = 0;
		for (int pt = 0; pt < t.length(); pt++) {
			if (s.charAt(ps) == t.charAt(pt)) {
				ps++;
				if (ps == s.length()) {
					return true;
				}
			}
		}
		return false;
	}
}
