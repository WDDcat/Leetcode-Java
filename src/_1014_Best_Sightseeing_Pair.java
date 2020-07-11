
public class _1014_Best_Sightseeing_Pair {
	public int maxScoreSightseeingPair(int[] A) {

		/*
		 * 	一开始的暴力解法超时了
		 * 	
		 * 	想了一下没想出来，看了官方题解也没看明白，
		 * 	但一个buff理论给我看的豁然开朗
		 * 	
		 * 	假设A[i]是在第i分钟上的buff A[i]的值是buff持续的时间
		 * 	这个buff会随时间减少：每过一分钟效力就减一
		 * 
		 * 	这样，在第j分钟时，第i个buff的效力就是A[i] - (j - i) ==> A[i] + i - j 
		 * 	再算一下当前j的buff加起来的和就是求一对景观分数的公式
		 * 
		 * 	贼高级！
		 * */
		
		int buff = A[0];
		int ans = 0;
		for (int j = 1; j < A.length; j++) {
			buff--;
			ans = Math.max(ans, buff + A[j]);
			// 同时要看现在的buff和新提供的buff哪个更强
			buff = Math.max(buff, A[j]);
		}
		return ans;
	}
}
