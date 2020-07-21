
public class JianZhi_Offer_11 {
	public int minArray(int[] numbers) {

		/*	本题与No. 154完全一致
		 * 	详见154.
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
