
public class _837_New_21_Game {
	public double new21Game(int N, int K, int W) {
		/*
		 * 	p[x]�ǵ÷�Ϊxʱ�Ļ�ʤ����
		 * 	Ŀ������p[0]
		 * 
		 * 	��x����  K �� x �� min(N, K-1 + W) ʱ  p[x] = 1
		 * 	x����      (min(N, K-1 + W) , +��)  ʱ  p[x]	= 0
		 * 	
		 * 	��Ϊ��[1,W]�г�ȡһ������
		 * 	����  dp[x] = (dp[x+1] + dp[x+2] + ... + dp[x+W]) / W
		 * 	*/
		
//		if(K == 0) {
//			return 1;
//		}
//		double[] dp = new double[K + W];
//		//��ʼ������
//		//��x����  K �� x �� min(N, K-1 + W) ʱ  p[x] = 1
//		for(int i = K; i <= N && i < K + W; i++) {
//			dp[i] = 1.0;
//		}
//		for(int i = K - 1; i >= 0; i--) {
//			//����dp[x+j]�ĺ�
//			for(int j = 1; j <= W; j++) {
//				dp[i] += dp[i+j] / W;
//			}
//		}
//		return dp[0];
		
		/*
		 * 	��Ϊͨ���Լ���˼���������Ľ����ܽ�����ˣ�������ֳ�ʱȻ����һ����������
		 * 	����Ϊ�����ͣ�
		 * 	
		 * 	����dp���ڵĲ�ֵ dp[x] - dp[x+1] = (dp[x+1] - dp[x+W+1]) / W  (0 �� x �� K - 1)
		 * 	
		 * 	��dp[x] = dp[x+1] + (dp[x+1] - dp[x+W+1]) / W  (0 �� x �� K - 1)
		 * 
		 * 	��x=K-1ʱ����Ҫ���⴦��
		 * 	dp[K-1] = (dp[K] + dp[K+1] + ... + dp[K+W-1]) / W
		 * 	
		 * 	�� K �� x �� min(N, K-1 + W) ʱ  p[x] = 1
		 * 	����
		 * 	dp[K-1] = (min(N , K + W - 1) - K + 1) / W = min(N - K + 1 , W) / W
		 * 	//��������û����
		 * 
		 * 	*/
		
		if (K == 0) {
            return 1.0;
        }
		double[] dp = new double[K + W];
		for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
		dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
		for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
		
        //�Ӵ˶�״̬ת�Ʒ������˸���̵���ʶ��
    }
}
