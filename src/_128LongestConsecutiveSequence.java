import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		
		/*
		 * 	һ���ͻᣬһ���ͷ�
		 * 	
		 * 	�����Ҷ��������ǲ�����
		 * 	
		 * 	ͨ��remove���ַ������Լ����ظ���ѯ
		 *	Ҳ�������2345���ŵĻ�
		 *	���2��ɾ����345
		 *	�����Ͳ�����ͨ��3̽����245
		 *	��������ʡ�Ժܶ�ʱ��
		 **/
		
		Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // ��ǰԪ�ص��������,eg: ��ǰΪ100, ������99��98��97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // ��ǰԪ�ص��ұ�����,eg: ��ǰΪ100, ������101��102��103,...
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // ����������longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
}
