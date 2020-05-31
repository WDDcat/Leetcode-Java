public class _76MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		/*
		 * 	一开始想到了一个复杂度很高的方法：
		 * 	一个循环控制s字串的长度，一个循环控制遍历，一个循环控制判断s中是否含有t中的字符
		 * 	发现时间复杂度暴增，实在没有办法看了题解。
		 * 	
		 * 	发现了一个很巧妙的实现
		 * 	使用 int[128] 来存放某一字符串中各个字符出现的次数,
		 * 	因为ASCII码只有0-127
		 * 	a[ch]++ 就可以将字符ch的数量加一
		 * 
		 * 	然后又学习了滑动窗格的算法，可以简化我实现前两个循环的工作量，把O(n^2)降为O(n)
		 * 	两个指针，右指针移动至第一个包含子串的位置，左指针移动至第一个不包含字串的位置
		 * 	记录此时的状态和长度。
		 * 	重复至结束，更新更短的状态和长度。
		 * 	这里minR的初始值设为-1是为了实现s="a" t = "b"的情况，应返回""
		 * */
		
		if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
		
		int[] needs = new int[128];	//统计t中字符出现次数
		int[] windows = new int[128];	//滑动窗口中字符出现次数
		
		for(char ch : t.toCharArray()) {
			needs[ch]++;
		}
		
		int l = 0, r = 0;
		int count = 0;
		
		int minLength = s.length() + 1;
		int minL = 0, minR = -1;
		
		while(r < s.length()) {
			char ch = s.charAt(r);
			if(needs[ch] > windows[ch]) {
				count++;
			}
			
			windows[ch]++;
			
			while(count == t.length()) {
				ch = s.charAt(l);
				if(needs[ch] == windows[ch]) {
					count--;
				}
				if(r - l + 1 < minLength) {
					minLength = r - l + 1;
					minL = l;
					minR = r;
				}
				windows[ch]--;
				l++;
			}
			r++;
		}
		
		return s.substring(minL, minR + 1);
    }
}
