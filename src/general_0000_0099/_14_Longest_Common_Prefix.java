package general_0000_0099;

public class _14_Longest_Common_Prefix {
	
	/*
	 * 	ͦ�򵥵��⣬����һ��˼·��
	 * 
	 * 	ȡ��һ��Ԫ�ص���������Ȼ����������
	 * 	�����в�ͬ�͸�����̹�����
	 * */
	
	public String longestCommonPrefix(String[] strs) {
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
