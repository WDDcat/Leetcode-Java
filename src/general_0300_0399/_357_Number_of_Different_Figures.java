package general_0300_0399;

public class _357_Number_of_Different_Figures {
	
	/*
	 * n = 0, 只有 0 这一个数字, ans(0) = 1;
	 * 
	 * n = 1, 除了 0 以外, 还有 1-9 九个数字 ans(1) = 9 + ans(0) = 10;
	 * 
	 * n = 2: 第一位1-9, 第二位是除了第一位外的 0-9 所以是 ans(2) = 9*9 + ans(1) = 81 + 9 + 1 = 91;
	 *   
	 * n = 3:       1-9  (0-9)-1  (0-9)-2
	 *                x     x      x          ans(3) = 9*9*8 + ans(2) = ...
	 * 
	 * n = 4:		1-9  (0-9)-1  (0-9)-2  (0-9)-3  ans(4) = 9*9*8*7 + ans(3)
	 *                x       x       x       x
	 * */
	
	public int countNumbersWithUniqueDigits(int n) {
		if(n == 0) return 1;
		int num = 9;
		for(int i = 1; i < n; i++) {
			num *= (9 - i);
		}
		return num + countNumbersWithUniqueDigits(n - 1);
    }
}
