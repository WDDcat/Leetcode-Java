
public class _35_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		
		/*
		 * 	�������ü�
		 * 	ֱ��ѭ�������
		 * */
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}
}
