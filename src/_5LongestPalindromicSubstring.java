
public class _5LongestPalindromicSubstring {
	/*
	 * 	�Լ�����һ����˼·�����˲��������󲹳���һ����
	 * 	�뵽�ķ������Ǳ����ַ����е�ÿһ��Ԫ�أ�����Ϊ������������չ
	 * 	���ܹ���ɻ��Ĵ��Ļ���������Ҳ���չ���ַ����
	 * 	������չ�������ַ������˻���չ���ַ������
	 * 
	 * 	��һ��ʼ�ķ�����û�п��ǵ�����Ϊ��������ַ���������� abba
	 * 	�������������󣬽��䲹��Ϊ����charAt(i)ʱ��̽����iΪ���� && ��i��i+1Ϊ���ĵ���չ��
	 * 	ʹ��left��right����¼��һ��̽���ɹ�����������ʼ�ͽ���*/
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
