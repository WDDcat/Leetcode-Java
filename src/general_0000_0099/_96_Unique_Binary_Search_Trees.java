package general_0000_0099;

public class _96_Unique_Binary_Search_Trees {
	
	/*
	 * 	�桤����Կɶ�̬�滮
	 * 	���� BST �Ķ��壬������� kȥ�������ڵ㣬������ 1 ~ k-1 ��ȥ������������k+1 ~ n ��ȥ����������
	 * 	�� k Ϊ���ڵ�� BST ������ = ������BST�������� * ������BST��������
	 * 
	 * 	����ı����ⷨ��֮Ϊ������������
	 * */
	
	public int numTrees(int n) {

//		int[] res = new int[] {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};
//		return res[n];
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}

		return dp[n];
	}
}
