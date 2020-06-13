
public class _70ClimbingStairs {
	public int climbStairs(int n) {
		/*
		 * 	练了这么多状态转移，还是第一时间没想到
		 * 	
		 * 	f(x) = f(x-1) + f(x-2)*/
		
		int last = 0;
		int current = 0;
		int next = 1;
		for(int i = 1; i <= n; i++) {
			last = current;
			current = next;
			next = last + current;
		}
		return next;
	}
}
