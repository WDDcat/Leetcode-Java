package general_0200_0299;
import java.util.PriorityQueue;

public class _215_Kth_Largest_Element_in_an_Array {
	
	/*
	 * 	使用最小堆实现
	 * 	存储最大的k个值
	 * 	堆的顶点就是第k个最大的
	 * */
	
	public int findKthLargest(int[] nums, int k) {
// 		暴力解就完事了
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
