package general_0200_0299;
import java.util.PriorityQueue;

public class _215_Kth_Largest_Element_in_an_Array {
	
	/*
	 * 	ʹ����С��ʵ��
	 * 	�洢����k��ֵ
	 * 	�ѵĶ�����ǵ�k������
	 * */
	
	public int findKthLargest(int[] nums, int k) {
// 		�������������
//		Arrays.sort(nums);
//		return nums[nums.length - k];
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int val : nums) {
			queue.add(val);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}
}
