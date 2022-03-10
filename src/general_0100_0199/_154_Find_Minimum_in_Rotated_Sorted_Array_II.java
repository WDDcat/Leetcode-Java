package general_0100_0199;

public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {
	
	/*
	 * 	���������е�Ī������
	 * 	ѭ����������С�ʹ�����������С��ʵ���Ͽ�����ȫ��ͬ
	 * 	������Ŀ�����Ĺ����ҵ�б��Ϊ����ĳһ��
	 * 	
	 * 	�����о���һ��
	 * 	���ʹ�����ƶ��ַ��Ĳ��ҷ������԰�ʱ�临�Ӷȴ�O(n)����O(lgn)
	 * 	����ʵ�������Ͷ��ֻ���һ������
	 * 	�����������ǷǼ������ǵ�����
	 * 	���Ը����˴�������ǵ�������������
	 * 	����������ִ�н����ʱ�䲢�����ر��š�
	 *  */
	
	public int findMin(int[] nums) {
		// ����С
//		int min = Integer.MAX_VALUE;
//		for(int n : nums) {
//			if(n < min) {
//				min= n;
//			}
//		}
//		return min;

		// ��ͻ����
//		for(int i = 1; i < nums.length - 1; i++) {
//			if(nums[i] < nums[i - 1]) {
//				return nums[i];
//			}
//		}
//		return nums[0];

		// ����
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
