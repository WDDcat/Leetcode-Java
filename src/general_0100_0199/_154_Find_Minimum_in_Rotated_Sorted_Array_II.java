package general_0100_0199;

public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {
	
	/*
	 * 	这题搞得我有点莫名其妙
	 * 	循环数组找最小和打乱数组找最小在实现上可以完全相同
	 * 	或按照题目所给的规律找到斜率为负的某一点
	 * 	
	 * 	后来研究了一下
	 * 	如果使用类似二分法的查找方法可以把时间复杂度从O(n)降至O(lgn)
	 * 	不过实现起来和二分还有一定区别
	 * 	但由于数组是非减而不是单增的
	 * 	所以给出了大量数组非递增的评判用例
	 * 	导致在最终执行结果上时间并不会特别优…
	 *  */
	
	public int findMin(int[] nums) {
		// 找最小
//		int min = Integer.MAX_VALUE;
//		for(int n : nums) {
//			if(n < min) {
//				min= n;
//			}
//		}
//		return min;

		// 找突降点
//		for(int i = 1; i < nums.length - 1; i++) {
//			if(nums[i] < nums[i - 1]) {
//				return nums[i];
//			}
//		}
//		return nums[0];

		// 二分
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int pivot = (low + high) / 2;
			if (nums[pivot] < nums[high]) {
				high = pivot;
			} else if (nums[pivot] > nums[high]) {
				low = pivot + 1;
			} else {
				high--;
			}
		}
		return nums[low];
	}
}
