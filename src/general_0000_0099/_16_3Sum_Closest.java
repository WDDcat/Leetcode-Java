package general_0000_0099;
import java.util.Arrays;

public class _16_3Sum_Closest {
	
	/*
	 * 	好像找三元组的题都需要用到  数组排序+双指针
	 * 	这个题与15题很类似，只不过一个是找0，一个是找目标值
	 * 	稍微改一改就可以了
	 * 	
	 * 	不过双指针还是没能自己写出来，下次争取自己写
	 * */
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int big = 10000;
		int small = -10000;
		int n = nums.length;
		for (int i = 0; i < n; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int L = i + 1, R = n - 1;
			while (L < R) {
				int cur = nums[i] + nums[L] + nums[R];
				if (cur - target == 0) {
					return cur;
				} else if (cur < target) {
					if (small < cur)
						small = cur;
					L++;
				} else {
					if (big > cur)
						big = cur;
					R--;
				}
			}
		}
		if (Math.abs(small - target) < Math.abs(big - target))
			return small;
		return big;
	}
}
