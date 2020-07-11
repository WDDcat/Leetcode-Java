import java.util.HashMap;

public class _1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
	public int findTheLongestSubstring(String s) {

		/*
		 * 5.20的题好难
		 * 	思路一点都没有，看了题解也不会，从评论里找到了一个比较好理解的
		 * 	
		 * 	aeiou每个元音用一个bit一共5个bit，32种奇偶次数组合状态，比如10101可以表示aiu出现奇数次数，oe则出现偶数次数
		 * 	每当遍历一个字符，就可以改变当前的aeiou出现的奇偶次数，也即是改变状态
		 * 	如果两次出现了同样的状态，假设第一次出现在i处，第二次出现在j处，
		 * 	那么i+1~j之间的字符串肯定是满足aeiou出现均为偶数次数的
		 * 	   aee	->  aee ->  aee 
		 * 	   i        ij      i j    -->> i+1 ~ j "ee"
		 * 	  10000    11000   10000
		 * 	为了使得合理的字符串最长，第一次出现此状态时，就需要记录到下标，然后下次遇到相同状态，计算最大长度
		 */
		
		// 记录某个状态第一次出现的位置i
		HashMap<Integer, Integer> stateToIndex = new HashMap<Integer, Integer>();
		// 初始状态为00000
		int state = 0x00000;
		// 记录00000的初始状态
		stateToIndex.putIfAbsent(state, -1);

		int maxLen = 0;

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'a':
				state ^= 0x10000;
				break;
			case 'e':
				state ^= 0x01000;
				break;
			case 'i':
				state ^= 0x00100;
				break;
			case 'o':
				state ^= 0x00010;
				break;
			case 'u':
				state ^= 0x00001;
				break;
			}

			if (stateToIndex.containsKey(state)) {
				maxLen = Math.max(maxLen, i - stateToIndex.get(state));
			}
			stateToIndex.putIfAbsent(state, i);
		}

		return maxLen;
	}
}
