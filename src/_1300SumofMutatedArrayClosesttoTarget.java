import java.util.Arrays;

public class _1300SumofMutatedArrayClosesttoTarget {
	public int findBestValue(int[] arr, int target) {
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			//i->length = length - i
			if(sum + arr[i] * (arr.length - i) <= target) {
				sum += arr[i];
			}
			else {
				double need = (target - sum) / (arr.length - i);
				double judge = need - (int) need;
				return (judge > 0.5) ? ((int) need + 1) : (int) need;
			}
		}
		return arr[arr.length - 1];
    }
}
