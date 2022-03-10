package general_0300_0399;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _336_Palindrome_Pairs {

	/*
	 * 	�ֵ������ֳƵ��ʲ�������Trie��������ͳ�ƣ�����ͱ���������ַ������ŵ��ǣ������ַ����Ĺ���ǰ׺�����ٲ�ѯʱ��
	 * 
	 * 	�����ַ�����ɻ��Ĵ�
	 * 	�������һ���ַ���һ�������һ���ֻ��Ĵ�������Ϊ�����ַ����ĳ��Ȳ�
	 * 	����Ҫ���Ĺ������� Ϊ �������Ĵ����ַ��� �� ���ಿ�� �ҵ�ƥ����ַ���
	 * 
	 *	����һ���������Ѱ���Ƿ�����������ַ���
	 */

	// �ֵ����Ľڵ�
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

	// �ж�һ���ַ����Ƿ��ǻ����ַ���
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
