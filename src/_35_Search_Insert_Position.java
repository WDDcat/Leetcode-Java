
public class _35_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		
		/*
		 * 	今天的题好简单
		 * 	直接循环解决了
		 * */
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}
}
