
public class _198_House_Robber {
	public int rob(int[] nums) {
		/*
		 * 	看到简单难度的题，然后就给想简单了
		 * 	本来想着这不是求奇数位和偶数位的和嘛，结果到[2,1,1,2]就翻车了
		 * 	然后就不争气的又去看了题解
		 * 	看到一个很有意思的公式
		 * 	
		 * 	dp[i] = max(dp[i-2] + nums[i], dp[i-1])
		 * 	就是当前的最大值就是取二者之一
		 * 	我不看代码自己写写看
		 * */
		
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1)	return nums[0];
		
		int i2 = nums[0], i1 = Math.max(nums[0], nums[1]); //i-2 & i-1
		for(int i = 2; i < nums.length; i++) {
			int max = Math.max(i2 + nums[i], i1);
			i2 = i1;
			i1 = max;
		}
		return i1;
    }
}
