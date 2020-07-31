
public class _392_Is_Subsequence {
	public boolean isSubsequence(String s, String t) {
		
		/*
		 * 	˫ָ�룬����
		 * 	����ⲻͬ����
		 * 	��������sָ��������������������
		 * 	�������Ҫ����t�е��������ַ�
		 * 	��ĳЩ�����ϻ��ʡʱ��
		 * */
		
		if (s.length() == 0 || t.length() == 0) {
			if (s.length() == 0)
				return true;
			else
				return false;
		}
		int ps = 0;
		for (int pt = 0; pt < t.length(); pt++) {
			if (s.charAt(ps) == t.charAt(pt)) {
				ps++;
				if (ps == s.length()) {
					return true;
				}
			}
		}
		return false;
	}
}
