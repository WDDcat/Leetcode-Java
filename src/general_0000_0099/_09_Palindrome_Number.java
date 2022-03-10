package general_0000_0099;

public class _09_Palindrome_Number {
	
	/*
	 * 	����ͦ�򵥵�һ���⣬������ĿҪ���Բ���string
	 * */
	
	public boolean isPalindrome(int x) {
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
