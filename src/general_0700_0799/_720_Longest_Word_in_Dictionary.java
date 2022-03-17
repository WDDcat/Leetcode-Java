package general_0700_0799;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _720_Longest_Word_in_Dictionary {
	
	public String longestWord(String[] words) {
		
		Arrays.sort(words, (a, b) -> {
			if(a.length() != b.length()) {
				return a.length() - b.length();
			} else {
				return b.compareTo(a);
			}
		});
		
		Set<String> set = new HashSet<>();
		String ans = "";
		set.add("");
		for(String s : words) {
			if(set.contains(s.substring(0, s.length() - 1))) {
				set.add(s);
				ans = s;
			}
		}
		return ans;
    }
}
