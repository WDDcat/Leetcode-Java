package general_0300_0399;

public class _357_Number_of_Different_Figures {
	public int countNumbersWithUniqueDigits(int n) {
		if(n == 0) return 1;
		int num = 9;
		for(int i = 1; i < n; i++) {
			num *= (9 - i);
		}
		return num + countNumbersWithUniqueDigits(n - 1);
    }
}
