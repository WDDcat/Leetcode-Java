import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _990_Satisfiability_of_Equality_Equations {	
	public boolean equationsPossible(String[] equations) {
		
		/*
		 * 	执行用时 :3 ms, 在所有 Java 提交中击败了39.27%的用户
		 * 	内存消耗 :39.2 MB, 在所有 Java 提交中击败了16.67%的用户
		 * 
		 * 	虽然这个时空复杂度都挺高的，但是！！！ 这是我自己琢磨出来的！！！
		 * 
		 * 	用了一个含有26个List的数组（因为就算每个字母都不一样也最多有26个值）
		 * 
		 * 	先遍历等于的情况，把相等的数都放到一个List里
		 * 	（这里涉及到合并的问题） a==b c==e b==c 就需要合并
		 * 	然后再遍历不等的情况，如果两个字符出现在同一个List里就说明不对了
		 * */
		
		List<Character> values[] = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			values[i] = new ArrayList<Character>();
		}

		for (String str : equations) {
			char a = str.charAt(0);
			char b = str.charAt(3);
			if (str.charAt(1) == '=') {
				int aAt = -1, bAt = -1, i;
				for (i = 0; i < values.length; i++) {
					if (values[i].size() == 0)
						break;
					if (values[i].contains(a))
						aAt = i;
					if (values[i].contains(b))
						bAt = i;
				}
				if (aAt == bAt) {
					if (aAt == -1) {
						values[i].add(a);
						values[i].add(b);
					}
				} else if (aAt == -1 || bAt == -1) {
					if (aAt == -1) {
						values[bAt].add(a);
					} else {
						values[aAt].add(b);
					}
				} else {
					if (aAt > bAt) {
						int temp = aAt;
						aAt = bAt;
						bAt = temp;
					}
					List<Character> temp = values[bAt];
					for (int j = 0; j < temp.size(); j++) {
						values[aAt].add(temp.get(j));
					}
					for (int j = values[bAt].size() - 1; j >= 0; j--) {
						values[bAt].remove(j);
					}
				}
			}
		}

		for (String str : equations) {
			char a = str.charAt(0);
			char b = str.charAt(3);
			if (str.charAt(1) == '!') {
				if (a == b)
					return false;
				for (int i = 0; i < values.length; i++) {
					if (values[i].size() == 0)
						break;
					if (values[i].contains(a) && values[i].contains(b))
						return false;
				}
			}
		}
		return true;
	}
}
