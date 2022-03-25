package general_0400_0499;

public class _440_Kth_Smallest_number_in_Dictionary_Order {
	public int findKthNumber(int n, int k) {
        int p = 1; // 指针，指向当前位置， p==k 时结束
        int prefix = 1;
        while(p < k) {
        	int count = getCount(prefix, n);
        	if(p + count > k) {
        		prefix *= 10;
        		p++;
        	} else if (p + count <= k) {
        		prefix++;
        		p += count;
        	}
        }
        return prefix;
    }
	
	/**
	 * @param prefix 前缀
	 * @param n      共有n个数
	 * @return
	 */
	private int getCount(long prefix, long n) {
		long cur = prefix;		// 当前前缀
		long next = prefix + 1;	// 下一个前缀
		int count = 0;
		
		while(cur <= n) {
			count += Math.min(next, n+1) - cur;
			cur *= 10;
			next *= 10;
		}
		return count;
	}
}
