package general_2000_2099;

public class _2044_Number_of_Max_Bit_Value_of_Subsets {
	
	/*
	 * 想了一部分，配合某一个评论，最后协议一个比较中等的答案
	 * 
	 * 1. 计算所有数的 或运算 的和
	 * 
	 * 2. 	利用 dfs
	 * 		分别从第零个元素遍历到第 n-1 个元素
	 * 		选择要或不要
	 * 		到达第 n 层时，判断或运算的和满不满足 maxValue 
	 * 
	 * 	[2,  1,  1]
	 *   0 - 0 - 0 
	 *     |   \ 1
	 *     \ 1 - 0
	 *         \ 1
	 *         
	 *         
	 *  后来我还尝试缩短时间，想把一开始计算的步骤省略，放在递归的过程中
	 *  后来发现好像在递归调用的过程中计算的次数反而不会减少
	 *  后来就放弃了这一想法。
	 * */
	
	public int countMaxOrSubsets(int[] nums) {
		int max = 0;
	    for(int num : nums) {
	        max |= num;
	    }
		return dfs(0, nums, 0, max);
    }
	
	private int dfs(int curIndex, int[] nums, int curValue, int max) {
		if(curIndex == nums.length) {
			return curValue == max ? 1 : 0;
		}
		return (dfs(curIndex + 1, nums, curValue, max)) 
				+ (dfs(curIndex + 1, nums, curValue | nums[curIndex], max));
	}
}
