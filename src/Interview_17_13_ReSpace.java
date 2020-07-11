import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Interview_17_13_ReSpace {
	public int respace(String[] dictionary, String sentence) {

		/*
		 * 	第 i + 1 个字符未匹配
		 * 		则 dp[i + 1] = dp[i] + 1，即不匹配数加 1; 
		 * 	遍历前 i 个字符
		 * 		若以其中某一个下标 idx为开头、以第 i + 1 个字符为结尾的字符串正好在词典里
		 *			 则 dp[i] = min(dp[i], dp[idx]) 更新 dp[i]
		 */

		Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
		int n = sentence.length();
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int idx = 0; idx < i; idx++) {
				if (dict.contains(sentence.substring(idx, i))) {
					dp[i] = Math.min(dp[i], dp[idx]);
				}
			}
		}
		return dp[n];
	}
}
