
public class _198_House_Robber {
	public int rob(int[] nums) {
		/*
		 * 	�������Ѷȵ��⣬Ȼ��͸������
		 * 	���������ⲻ��������λ��ż��λ�ĺ�������[2,1,1,2]�ͷ�����
		 * 	Ȼ��Ͳ���������ȥ�������
		 * 	����һ��������˼�Ĺ�ʽ
		 * 	
		 * 	dp[i] = max(dp[i-2] + nums[i], dp[i-1])
		 * 	���ǵ�ǰ�����ֵ����ȡ����֮һ
		 * 	�Ҳ��������Լ�дд��
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
