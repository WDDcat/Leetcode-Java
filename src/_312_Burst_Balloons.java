
public class _312_Burst_Balloons {
	public int maxCoins(int[] nums) {

		/*
		 * 	�ǳ�����˼��һ����̬�滮��
		 * 	i j ��ʾ�˿����� ��i��j���ܵõ�������Ӳ����
		 * 	
		 * 	״ֵ̬�ļ������������kֵ��������
		 * 	�������� [ i, ..., k, ..., j]��
		 * 	����������������k����dp[i][j] = nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]
		 * 	����������Ҫ��k�ڣ�i��j�������ڵ����п��ܣ���ȡ���ֵ
		 * 
		 * 	��󷵻ص�ֵ��Ϊdp[0][n + 1]
		 * 
		 * 	���м����״ֵ̬�Ĺ����У�����i��j֮���ֵ����������Ҫ��С��ֵ����������
		 * 	���Բ����ܰ�0->n�����ķ�ʽ����
		 * 	1. �ҵĴ�����д����ʹ�á����ȡ� + ����ڵ㡱 ö��
		 * 	2. ����һ�ַ�ʽ�ǡ�i��n->0�� + ��j: i+1->n�� �ķ�ʽ����ö��
		 * */
		
		int n = nums.length;
		int[][] dp = new int[n + 2][n + 2];

		// ����һ��������������ԭ����ı߽�ֵ,��ѭ�������������ж�
		int[] val = new int[n + 2];
		val[0] = val[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
			val[i] = nums[i - 1];
		}

		for (int len = 1; len <= n + 2; len++) {
			for (int i = 0; i + len - 1 <= n + 1; i++) {
				int j = i + len - 1;
				if (len <= 2)
					dp[i][j] = 0;
				for (int k = i + 1; k < j; k++) {
					int coin = val[i] * val[k] * val[j];
					int sum = coin + dp[i][k] + dp[k][j];
					dp[i][j] = Math.max(dp[i][j], sum);
				}
			}
		}
		return dp[0][n + 1];
	}
}
