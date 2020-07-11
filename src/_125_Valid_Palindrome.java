
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
	 * 	�����ɾ���д���������������ж�
	 * 	1. �Ƿ�����ĸ������
	 * 	2. ȥ��д
	 * 
	 * 	�����������˼�Java�������ô�߼��ĺ���
	 * 	isLetterOrDigit
	 * 	toLowerCase
	 * 	
	 * 	���������
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
