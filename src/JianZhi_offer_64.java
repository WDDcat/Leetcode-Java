
public class JianZhi_offer_64 {
	public int sumNums(int n) {
//		return n == 0 ? 0 : n + sumNums(n - 1);
		
		/*
		 * 	����һ��֪ʶ��ϰ��
		 * 	һ��ʼ�뵽�ķ������ǵݹ飬��û�а취�жϵݹ�Ľ���λ��
		 * 	
		 * 	Ȼ�����������������߼�������Ķ�·����
		 * 	�� A && Bʱ�����A�Ѿ���false���򲻻�ȥִ��B������
		  */
		
		Boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
		return n;
    }
}
