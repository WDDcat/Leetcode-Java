
public class JianZhi_Offer_11 {
	public int minArray(int[] numbers) {

		/*	������No. 154��ȫһ��
		 * 	���154.
		 */
		
		int min = Integer.MAX_VALUE;
		for (int n : numbers) {
			if (n < min) {
				min = n;
			}
		}
		return min;
	}
}
