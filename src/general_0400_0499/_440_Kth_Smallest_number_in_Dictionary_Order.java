package general_0400_0499;

public class _440_Kth_Smallest_number_in_Dictionary_Order {
	public int findKthNumber(int n, int k) {
        int p = 1; // ָ�룬ָ��ǰλ�ã� p==k ʱ����
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
	 * @param prefix ǰ׺
	 * @param n      ����n����
	 * @return
	 */
	private int getCount(long prefix, long n) {
		long cur = prefix;		// ��ǰǰ׺
		long next = prefix + 1;	// ��һ��ǰ׺
		int count = 0;
		
		while(cur <= n) {
			count += Math.min(next, n+1) - cur;
			cur *= 10;
			next *= 10;
		}
		return count;
	}
}
