import java.util.HashMap;

public class _1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
	public int findTheLongestSubstring(String s) {

		/*
		 * 5.20�������
		 * 	˼·һ�㶼û�У��������Ҳ���ᣬ���������ҵ���һ���ȽϺ�����
		 * 	
		 * 	aeiouÿ��Ԫ����һ��bitһ��5��bit��32����ż�������״̬������10101���Ա�ʾaiu��������������oe�����ż������
		 * 	ÿ������һ���ַ����Ϳ��Ըı䵱ǰ��aeiou���ֵ���ż������Ҳ���Ǹı�״̬
		 * 	������γ�����ͬ����״̬�������һ�γ�����i�����ڶ��γ�����j����
		 * 	��ôi+1~j֮����ַ����϶�������aeiou���־�Ϊż��������
		 * 	   aee	->  aee ->  aee 
		 * 	   i        ij      i j    -->> i+1 ~ j "ee"
		 * 	  10000    11000   10000
		 * 	Ϊ��ʹ�ú�����ַ��������һ�γ��ִ�״̬ʱ������Ҫ��¼���±꣬Ȼ���´�������ͬ״̬��������󳤶�
		 */
		
		// ��¼ĳ��״̬��һ�γ��ֵ�λ��i
		HashMap<Integer, Integer> stateToIndex = new HashMap<Integer, Integer>();
		// ��ʼ״̬Ϊ00000
		int state = 0x00000;
		// ��¼00000�ĳ�ʼ״̬
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
