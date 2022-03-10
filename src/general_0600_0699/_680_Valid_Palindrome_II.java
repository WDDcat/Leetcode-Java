package general_0600_0699;

public class _680_Valid_Palindrome_II {
	public boolean validPalindrome(String s) {
		//ѭ������ȡ�ַ�����һ�볤��
		for(int i = 0; i < s.length() / 2; i++) {
			/*
			ʵ�ֿɰ���һ�����ַ��ķ���Ϊ��
			�����ֵ�i���͵�j�� �����ַ���ƥ��ʱ��
			�ж�i+1��j || i��j-1 �������ַ����Ƿ�Ϊ���Ĵ� 
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
