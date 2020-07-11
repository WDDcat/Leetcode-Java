import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _990_Satisfiability_of_Equality_Equations {	
	public boolean equationsPossible(String[] equations) {
		
		/*
		 * 	ִ����ʱ :3 ms, ������ Java �ύ�л�����39.27%���û�
		 * 	�ڴ����� :39.2 MB, ������ Java �ύ�л�����16.67%���û�
		 * 
		 * 	��Ȼ���ʱ�ո��Ӷȶ�ͦ�ߵģ����ǣ����� �������Լ���ĥ�����ģ�����
		 * 
		 * 	����һ������26��List�����飨��Ϊ����ÿ����ĸ����һ��Ҳ�����26��ֵ��
		 * 
		 * 	�ȱ������ڵ����������ȵ������ŵ�һ��List��
		 * 	�������漰���ϲ������⣩ a==b c==e b==c ����Ҫ�ϲ�
		 * 	Ȼ���ٱ������ȵ��������������ַ�������ͬһ��List���˵��������
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
