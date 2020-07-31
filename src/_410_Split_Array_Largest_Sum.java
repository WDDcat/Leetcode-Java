
public class _410_Split_Array_Largest_Sum {
	
	/*	截取了题解中的一部分说明：
	 * 
	 * 	本题中，我们注意到：
	 * 	当我们选定一个值 x，我们可以线性地验证是否存在一种分割方案，
	 * 	满足其最大分割子数组和不超过 x。
	 * 	策略如下：
	 * 
	 * 	贪心地模拟分割的过程，从前到后遍历数组，用sum 表示当前分割子数组的和，
	 * 	cnt 表示已经分割出的子数组的数量（包括当前子数组）
	 * 	那么每当sum 加上当前值超过了 x，
	 * 	我们就把当前取的值作为新的一段分割子数组的开头，
	 * 	并将cnt 加 1。
	 * 	遍历结束后验证是否cnt不超过m。
	 * 
	 * 	这样我们可以用二分查找来解决。
	 * 	二分的上界为数组 nums中所有元素的和，
	 * 	下界为数组 nums中所有元素的最大值
	 * 	通过二分查找，我们可以得到最小的最大分割子数组和，这样就可以得到最终的答案了。
	 * */
	
	public int splitArray(int[] nums, int m) {
		int min = 0;
		int max = 0;

		// 初始化二分边界
		for (int n : nums) {
			max += n;
			if (min < n) {
				min = n;
			}
		}

		// 对最大值进行二分查找
		while (min < max) {
			int mid = (max - min) / 2 + min;
			if (check(nums, m, mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	// 贪心查找查找最大值的最小值
	boolean check(int[] nums, int m, int x) {
		int sum = 0;
		int cnt = 1;
		for (int n : nums) {
			if (n + sum <= x) {
				sum += n;
			} else {
				cnt++;
				sum = n;
			}
		}
		return cnt <= m;
	}
}
