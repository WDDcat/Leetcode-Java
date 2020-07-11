import java.util.Arrays;

public class _41_First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
		
		/*
		 * 	由于说了需要时间O(n)且空间有限
		 * 	官方给的解法简直太神奇了
		 * 
		 *	两种解法
		 *	的根据就是
		 *	如果数组长为n，那么要么就是数组为[1,2,...,n]这样返回值为【n+1】， 要么就中间有一项空缺所以只在数组内部做文章就可以了
		 *
		 *	1. 哈希表
		 *	首先将<0的项变为n+1
		 *	将≤n的项对应的位置置为负数  如：nums[0] = 3 则将 nums[3 - 1] = -abs(nums[3 - 1])
		 *	这样，只要第x位存在过，那一位对应的数字就是负数
		 *	找到第一个正数对应的下标+1 || n+1 
		 *
		 *	2.置换
		 *	将某个数组尽量置换为[1,2,...,n]
		 *	若然后如果缺失的(<=0)就填补空挡
		 *	这样第一个不在位置上的数就是缺失的数
		 **/

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}
	
	/*
	 * if(nums == null || nums.length == 0) return 1;
        
        Arrays.sort(nums);
		
		int i = 0;
		while(i < nums.length && nums[i] <= 0) {
			i++;
		}
		System.out.println(i);
		int last = 0;
		while(i < nums.length) {
			if(nums[i] - last > 1) return (last + 1);
            last = nums[i];
			i++;
		}
		return (nums[nums.length - 1] + 1) > 0 ? nums[nums.length - 1] + 1 : 1;
	 * */
}
