package jian_zhi;

public class JianZhi_Offer_11 {
	
	/*	������No. 154��ȫһ��
	 * 	���154.
	 */
	
	public int minArray(int[] numbers) {
		int min = Integer.MAX_VALUE;
		for (int n : numbers) {
			if (n < min) {
				min = n;
			}
		}
		return min;
	}
}
