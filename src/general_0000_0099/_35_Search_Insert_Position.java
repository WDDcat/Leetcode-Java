package general_0000_0099;

public class _35_Search_Insert_Position {
	
	/*
	 * 	今天的题好简单
	 * 	直接循环解决了
	 * */
	
	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}
}
