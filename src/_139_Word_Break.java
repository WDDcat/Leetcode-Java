import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _139_Word_Break {
	
	/*
	 * 	DFS
	 * 	
	 * 	leetcode
	 * 	l,eetcode   le,etcode   lee,tcode   leet,code   leetc,ode   leetco,de   leetcod,e   leetcode
	 *                                      c,ode   co,de  cod,e   code
	 *	��ž�����˼
	 *	һ��ʼ��û��memo��صĴ����
	 *	�������ѳ����˱Ƚϸ��ӵ����
	 *	����
	 *  ��aaaaaaaa...aaaaaaaaaaa��
	 *  ["a", "aa", "aaa" ...]
	 *	�����ͻ��ظ��Ų������ظ����
	 *	���Ǿ������һ����ϣ���ӵ�n�ʼ���Ų���
	 *	����Ѿ��Ų���˾�ֱ�ӷ���
	 *	�������
	 *  
	 *  */
	
	List<String> dict = new ArrayList<>();
	Map<Integer, Boolean> memo = new HashMap<>();
	
	public boolean wordBreak(String s, List<String> wordDict) {
		dict = wordDict;
		return check(s, 0);
    }
	
	boolean check(String s, int n) {
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		if(n == s.length()) return true;
		for(int i = n; i <= s.length(); i++) {
			String word = s.substring(n, i);
			System.out.println(word);
			if(dict.contains(word) && check(s, i)) {
				memo.put(n, true);
				return true;
			}
		}
		memo.put(n, false);
		return false;
	}
}
