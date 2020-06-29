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
	 *	大概就这意思
	 *	一开始是没有memo相关的代码的
	 *	但是深搜出现了比较复杂的情况
	 *	就是
	 *  “aaaaaaaa...aaaaaaaaaaa”
	 *  ["a", "aa", "aaa" ...]
	 *	这样就会重复排查后面的重复情况
	 *	于是就设计了一个哈希表存从第n项开始的排查结果
	 *	如果已经排查过了就直接返回
	 *	就完成了
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
