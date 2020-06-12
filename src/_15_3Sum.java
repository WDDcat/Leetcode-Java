import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		
		/*
		 * 	下意识想到三个循环，然后就想到一定会超时
		 * 	后来发现不仅会超时，还会出现重复解
		 * 	想到了排序，然后重复的就continue i++
		 * 
		 * 	后来还是不行
		 * 	还是看了题解
		 * 	
		 * 	利用排序完了加和等于0时一定有一负数筛掉第一个值是正的情况
		 * 	双指针利用了加和特性从两边往中间遍历
		 * 	妙啊
		 * */
		
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			if(nums[i] > 0) return ans;
			
			if(i > 0 && nums[i] == nums[i-1]) continue;
			
			int L = i+1, R = n-1;
			while(L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if(sum == 0) {
					List<Integer> unit = new ArrayList<>();
					unit.add(nums[i]);
					unit.add(nums[L]);
					unit.add(nums[R]);
					ans.add(unit);
					
					while(L<R && nums[L+1] == nums[L]) L++;
					while(L<R && nums[R-1] == nums[R]) R--;
					
					L++;
					R--;
				}
				else if(sum < 0) {
					L++;
				}
				else {
					R--;
				}
			}
		}
		return ans;
    }
}
