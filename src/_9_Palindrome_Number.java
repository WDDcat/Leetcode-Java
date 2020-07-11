
public class _9_Palindrome_Number {
	public boolean isPalindrome(int x) {
		/*
		 * 	本来挺简单的一个题，发现题目要求尝试不用string
		 * */
//		String str = String.valueOf(x);
//		int length = str.length();
//		
//		for(int i = 0; i < length / 2; i++) {
//			if(str.charAt(i) != str.charAt(length - 1 - i)) return false;
//		}
//		return true;
		
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		return x == revertedNumber || x == revertedNumber / 10;
	}
}
