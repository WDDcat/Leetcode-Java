
public class _125_Valid_Palindrome {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	/*
	 * 	本来吧觉得写了两个函数用于判断
	 * 	1. 是否是字母或数字
	 * 	2. 去大写
	 * 
	 * 	结果看了题解人家Java里就有这么高级的函数
	 * 	isLetterOrDigit
	 * 	toLowerCase
	 * 	
	 * 	世界真奇妙！
	 * 	*/
	
// boolean isLegal(char c) {
//		if(c >= 48 && c <= 57) return true;
//		if(c >= 65 && c <= 90) return true;
//		if(c >= 97 && c <= 122) return true;
//		return false;
//	}
//	
//	char uncapital(char c) {
//		if(c >= 65 && c <= 90) {
//			return (char) (c + 32);
//		}
//		return c;
//	}
}
