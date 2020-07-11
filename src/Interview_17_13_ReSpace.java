import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Interview_17_13_ReSpace {
	public int respace(String[] dictionary, String sentence) {

		/*
		 * 	�� i + 1 ���ַ�δƥ��
		 * 		�� dp[i + 1] = dp[i] + 1������ƥ������ 1; 
		 * 	����ǰ i ���ַ�
		 * 		��������ĳһ���±� idxΪ��ͷ���Ե� i + 1 ���ַ�Ϊ��β���ַ��������ڴʵ���
		 *			 �� dp[i] = min(dp[i], dp[idx]) ���� dp[i]
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
