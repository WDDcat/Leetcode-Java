package general_0100_0199;

public class _167_Two_Sum_II_Input_array_is_sorted {
	
	/*
	 * 	排序加双指针
	 * 	这题连排序都不用了
	 * */
	
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			}
			if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return new int[] { -1, -1 };
	}
}
