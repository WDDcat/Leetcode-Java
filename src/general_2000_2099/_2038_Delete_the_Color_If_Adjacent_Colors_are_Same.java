package general_2000_2099;

public class _2038_Delete_the_Color_If_Adjacent_Colors_are_Same {
	
	/*
	 * 自己又想了个方法
	 * 从左往右遍历一遍 String 记录 "AAA" 和 "BBB" 的个数
	 * "AAAA" 就记作两个
	 * 因为 某一方 删除字母不会影响 另一方
	 * 最后比较谁的多就行了
	 * 
	 * @ 我这里用的方法是记录前两个看到的值，然后三个相等就计数
	 * @ 题解用的方法是记录相同字母的数量，≥3就计数
	 * */
	
	public boolean winnerOfGame(String colors) {
		if(colors.length() < 3) {
			return false;
		}
		
		char last, lastlast;
		lastlast = colors.charAt(0);
		last = colors.charAt(1);
		int a = 0, b = 0;
		for(int i = 2; i < colors.length(); i++) {
			char cur = colors.charAt(i);
			if(cur == last && last == lastlast) {
				if(last == 'A') a++;
				else b++;
			}
			lastlast = last;
			last = cur;
		}
		return a > b;
    }
	
	/*
	 * 最简单的方法
	 * 每次找一个 "AAA"-》"AA" 然后再找一个 "BBB"-》"BB"
	 * 找不出来就输
	 * 可惜 超时了
	 * */
	
//	public boolean winnerOfGame(String colors) {
//		StringBuilder sb = new StringBuilder(colors);
//		while(true) {
//			int i;
//			if((i = sb.indexOf("AAA")) >= 0) {
//				sb.replace(i, i + 3, "AA");
//				System.out.println(sb.toString());
//			} else {
//				return false;
//			}
//			
//			if((i = sb.indexOf("BBB")) >= 0) {
//				sb.replace(i, i + 3, "BB");
//				System.out.println(sb.toString());
//			} else {
//				return true;
//			}
//		}
//    }
}
