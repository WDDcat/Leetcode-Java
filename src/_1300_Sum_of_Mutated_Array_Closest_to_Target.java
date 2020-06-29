import java.util.Arrays;

public class _1300_Sum_of_Mutated_Array_Closest_to_Target {
	public int findBestValue(int[] arr, int target) {
		
		/*
		 * 	好像比题解还优了一些？
		 * 	
		 * 	先排序
		 * 	然后遍历
		 * 	看（如果后面的数字都等于这个数的话）的总和超没超target
		 * 	没超就下一个
		 * 	超了就用target - （这个数前面的）总和 然后除以 后面上下的个数 得到均值
		 * 	
		 * 	第一次做的时候没考虑到加和的绝对值之差最小，就没考虑超出target时的情况
		 * 	于是加了double判断求出的均值是否大于0.5的判断
		 * */
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
