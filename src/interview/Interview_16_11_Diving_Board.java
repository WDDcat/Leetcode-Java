package interview;

public class Interview_16_11_Diving_Board {
	
	/*
	 * 	感觉需要证明不会重复？
	 * */
	
	public int[] divingBoard(int shorter, int longer, int k) {
		if (k == 0) {
			return new int[0];
		}
		if (shorter == longer) {
			return new int[] { shorter * k };
		}
		int[] lengths = new int[k + 1];
		for (int i = 0; i <= k; i++) {
			lengths[i] = shorter * (k - i) + longer * i;
		}
		return lengths;
	}
}
