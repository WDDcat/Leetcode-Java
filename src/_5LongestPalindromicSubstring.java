
public class _5LongestPalindromicSubstring {
	/*
	 * 	自己想了一部分思路，看了测试用例后补充了一部分
	 * 	想到的方法就是便利字符串中的每一个元素，以其为中心向左右扩展
	 * 	若能够组成回文串的话，左侧与右侧扩展的字符相等
	 * 	不断扩展至到达字符串两端或扩展的字符不相等
	 * 
	 * 	但一开始的方案中没有考虑到中心为两个相等字符的情况，即 abba
	 * 	看到测试用例后，将其补充为访问charAt(i)时，探索以i为中心 && 以i与i+1为中心的扩展串
	 * 	使用left和right来记录上一次探索成功后的最长串的起始和结束*/
	public String longestPalindrome(String s) {
		if(s == null || s.length() < 1) return "";
		int left = 0, right = 0;
		for(int i = 0; i < s.length(); i++) {
			int len1 = expandCenter(s, i, i);
			int len2 = expandCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if(len > right - left) {
				left = i - (len - 1) / 2;
				right = i + len / 2;
			}
		}
		
		return s.substring(left, right + 1);
    }
	
	private int expandCenter(String s, int left, int right) {
		int L = left, R = right;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
}
