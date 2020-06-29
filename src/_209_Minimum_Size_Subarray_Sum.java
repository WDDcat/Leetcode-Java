
public class _209_Minimum_Size_Subarray_Sum {
	public int minSubArrayLen(int s, int[] nums) {
		
		/*
		 * 	˫ָ��
		 * 	ָ��֮��е���������end���ƣ����˾�startǰ�ƣ���¼��end-start��С�����
		 * 	*/
		
		int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
