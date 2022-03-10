package general_0600_0699;

public class _680_Valid_Palindrome_II {
	public boolean validPalindrome(String s) {
		//循环数量取字符串的一半长度
		for(int i = 0; i < s.length() / 2; i++) {
			/*
			实现可包容一个错字符的方法为：
			当发现第i个和第j个 两个字符不匹配时，
			判断i+1与j || i与j-1 这两个字符串是否为回文串 
			*/
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return isValid(s, i + 1, s.length() - 1 - i) || isValid(s, i, s.length() - 2 - i);
			}
		}
		return true;
	}

	private boolean isValid(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
