package general_0300_0399;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _336_Palindrome_Pairs {

	/*
	 * 	字典树，又称单词查找树，Trie树，用于统计，排序和保存大量的字符串。优点是：利用字符串的公共前缀来减少查询时间
	 * 
	 * 	两个字符串组成回文串
	 * 	则更长的一个字符串一定会包含一部分回文串，长度为两个字符串的长度差
	 * 	还需要做的工作就是 为 包含回文串的字符串 的 其余部分 找到匹配的字符串
	 * 
	 *	利用一个树来快捷寻找是否存在这样的字符串
	 */

	// 字典树的节点
	private class Node {
		int id;
		int[] ch;

		Node() {
			id = -1;
			ch = new int[26];
		}
	}

	private List<Node> tree = new ArrayList<Node>();

	public List<List<Integer>> palindromePairs(String[] words) {
		tree.add(new Node());
		int n = words.length;
		for (int i = 0; i < n; i++) {
			insert(words[i], i);
		}
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			int m = words[i].length();
			for (int j = 0; j <= m; j++) {

				// "abc baab" find "cba"
				if (isPalindrome(words[i], j, m - 1)) {
					int leftId = findWord(words[i], 0, j - 1);
					if (leftId != -1 && leftId != i) {
						ret.add(Arrays.asList(i, leftId));
					}
				}

				// "baab abc" find "cba"
				if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
					int rightId = findWord(words[i], j, m - 1);
					if (rightId != -1 && rightId != i) {
						ret.add(Arrays.asList(rightId, i));
					}
				}
			}
		}
		return ret;
	}

	private void insert(String s, int id) {
		int len = s.length(), add = 0;
		for (int i = 0; i < len; i++) {
			int x = s.charAt(i) - 'a';
			if (tree.get(add).ch[x] == 0) {
				tree.add(new Node());
				tree.get(add).ch[x] = tree.size() - 1;
			}
			add = tree.get(add).ch[x];
		}
		tree.get(add).id = id;
	}

	// 判断一个字符串是否是回文字符串
	private boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}
	
	private int findWord(String s, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).id;
    }
}
