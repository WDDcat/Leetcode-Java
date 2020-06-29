
public class _837_New_21_Game {
	public double new21Game(int N, int K, int W) {
		/*
		 * 	p[x]是得分为x时的获胜概率
		 * 	目标是求p[0]
		 * 
		 * 	当x满足  K ≤ x ≤ min(N, K-1 + W) 时  p[x] = 1
		 * 	x满足      (min(N, K-1 + W) , +∞)  时  p[x]	= 0
		 * 	
		 * 	因为从[1,W]中抽取一个整数
		 * 	所以  dp[x] = (dp[x+1] + dp[x+2] + ... + dp[x+W]) / W
		 * 	*/
		
//		if(K == 0) {
//			return 1;
//		}
//		double[] dp = new double[K + W];
//		//初始化数组
//		//当x满足  K ≤ x ≤ min(N, K-1 + W) 时  p[x] = 1
//		for(int i = K; i <= N && i < K + W; i++) {
//			dp[i] = 1.0;
//		}
//		for(int i = K - 1; i >= 0; i--) {
//			//计算dp[x+j]的和
//			for(int j = 1; j <= W; j++) {
//				dp[i] += dp[i+j] / W;
//			}
//		}
//		return dp[0];
		
		/*
		 * 	以为通过自己的思考加上题解的解释能解出题了，结果发现超时然后再一看还有下文
		 * 	以下为题解解释：
		 * 	
		 * 	计算dp相邻的差值 dp[x] - dp[x+1] = (dp[x+1] - dp[x+W+1]) / W  (0 ≤ x ≤ K - 1)
		 * 	
		 * 	则dp[x] = dp[x+1] + (dp[x+1] - dp[x+W+1]) / W  (0 ≤ x ≤ K - 1)
		 * 
		 * 	当x=K-1时，需要特殊处理
		 * 	dp[K-1] = (dp[K] + dp[K+1] + ... + dp[K+W-1]) / W
		 * 	
		 * 	当 K ≤ x ≤ min(N, K-1 + W) 时  p[x] = 1
		 * 	所以
		 * 	dp[K-1] = (min(N , K + W - 1) - K + 1) / W = min(N - K + 1 , W) / W
		 * 	//以上三行没看懂
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
		
        //从此对状态转移方程有了更深刻的认识。
    }
}
