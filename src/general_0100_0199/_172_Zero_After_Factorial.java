package general_0100_0199;

public class _172_Zero_After_Factorial {
	
	/*
	 * 发现了一个递归解法，很有意思
	 */
	
	public int trailingZeroes(int n) {
		if(n < 5) return 0;
		return n / 5 + trailingZeroes(n / 5);
	}
	
	/*
	 * 数末位零数量的话 基本就是数 2 和 5
	 * 
	 * n / 10 = m ... k
	 * m 有多少就有多少个 10 2 5 -> 一共就是2个零
	 * k >= 5 的话 就又多一个零
	 * 
	 * 然后再考虑 5^p 这样的情况
	 * 题目说 0 <= n <= 10^4 那一共就有下面几个数，分别判断一下就行了
	 * 因为 2的因子 肯定比 5 多，所以只考虑有多少5就可以
	 * 每一个 5^p 的倍数也要考虑
	 */
	
//	public int trailingZeroes(int n) {
//		return n/5+n/25+n/125+n/625+n/3125;
//    }
}
