package jian_zhi;

public class JianZhi_Offer_64 {
	
	/*
	 * 	����һ��֪ʶ��ϰ��
	 * 	һ��ʼ�뵽�ķ������ǵݹ飬��û�а취�жϵݹ�Ľ���λ��
	 * 	
	 * 	Ȼ�����������������߼�������Ķ�·����
	 * 	�� A && Bʱ�����A�Ѿ���false���򲻻�ȥִ��B������
	  */
	
	public int sumNums(int n) {
//		return n == 0 ? 0 : n + sumNums(n - 1);
		
		@SuppressWarnings("unused")
		Boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
		return n;
	}
}
