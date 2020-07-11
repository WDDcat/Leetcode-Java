
public class _67_Add_Binary {
	public String addBinary(String a, String b) {
		
		/*
		 * 	时空肯定没有人家位运算的高
		 * 	但也算是提供了另一种不一样的方法
		 * */
		
		if (a.length() < b.length()) {
			String temp = b;
			b = a;
			a = temp;
		}
		while (b.length() < a.length()) {
			b = "0" + b;
		}
		int length = a.length();
		StringBuilder ans = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < length; i++) {
			int cur = Integer.valueOf(a.charAt(a.length() - 1) - 48) + Integer.valueOf(b.charAt(b.length() - 1) - 48)
					+ carry;
			if (cur == 0 || cur == 1) {
				ans.insert(0, cur);
				carry = 0;
			} else if (cur == 2) {
				ans.insert(0, "0");
				carry = 1;
			} else {
				ans.insert(0, "1");
				carry = 1;
			}

			a = a.substring(0, a.length() - 1);
			b = b.substring(0, b.length() - 1);

			if (a.length() == 0 && b.length() == 0) {
				if (carry == 1) {
					ans.insert(0, "1");
				}
				break;
			}
		}
		return ans.toString();
	}
}
