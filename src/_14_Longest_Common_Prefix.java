
public class _14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {

		/*
		 * 	挺简单的题，换了一种思路解
		 * 
		 * 	取第一个元素当公共串，然后遍历后面的
		 * 	发现有不同就更新最短公共串
		 * */
		
		String ans = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (ans.equals(""))
				return "";
			if (strs[i].length() < ans.length()) {
				ans = ans.substring(0, strs[i].length());
			}
			for (int j = 0; j < ans.length(); j++) {
				if (ans.charAt(j) != strs[i].charAt(j)) {
					ans = ans.substring(0, j);
				}
			}
		}
		return ans;
	}
}
