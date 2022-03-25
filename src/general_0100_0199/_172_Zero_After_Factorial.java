package general_0100_0199;

public class _172_Zero_After_Factorial {
	
	/*
	 * ������һ���ݹ�ⷨ��������˼
	 */
	
	public int trailingZeroes(int n) {
		if(n < 5) return 0;
		return n / 5 + trailingZeroes(n / 5);
	}
	
	/*
	 * ��ĩλ�������Ļ� ���������� 2 �� 5
	 * 
	 * n / 10 = m ... k
	 * m �ж��پ��ж��ٸ� 10 2 5 -> һ������2����
	 * k >= 5 �Ļ� ���ֶ�һ����
	 * 
	 * Ȼ���ٿ��� 5^p ���������
	 * ��Ŀ˵ 0 <= n <= 10^4 ��һ���������漸�������ֱ��ж�һ�¾�����
	 * ��Ϊ 2������ �϶��� 5 �࣬����ֻ�����ж���5�Ϳ���
	 * ÿһ�� 5^p �ı���ҲҪ����
	 */
	
//	public int trailingZeroes(int n) {
//		return n/5+n/25+n/125+n/625+n/3125;
//    }
}
