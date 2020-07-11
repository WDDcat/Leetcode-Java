
public class _718_Maximum_Length_of_Repeated_Subarray {
	public int findLength(int[] A, int[] B) {
		
		/*
		 * 	״̬ת�Ʒ��̣����������Ĳ����
		 * 
		 * 	i��A�е�λ�ã�j��B�е�λ��
		 * 	dp[i][j] = dp[i - 1][j - 1] + 1
		 * 	*/
		
		int max = 0;
		int[][] dp = new int[A.length + 1][B.length + 1];

		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}
}
