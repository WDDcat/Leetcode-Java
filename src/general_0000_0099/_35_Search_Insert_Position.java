package general_0000_0099;

public class _35_Search_Insert_Position {
	
	/*
	 * 	�������ü�
	 * 	ֱ��ѭ�������
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
