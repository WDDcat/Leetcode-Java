
public class _1014_Best_Sightseeing_Pair {
	public int maxScoreSightseeingPair(int[] A) {

		/*
		 * 	һ��ʼ�ı����ⷨ��ʱ��
		 * 	
		 * 	����һ��û����������˹ٷ����Ҳû�����ף�
		 * 	��һ��buff���۸��ҿ��Ļ�Ȼ����
		 * 	
		 * 	����A[i]���ڵ�i�����ϵ�buff A[i]��ֵ��buff������ʱ��
		 * 	���buff����ʱ����٣�ÿ��һ����Ч���ͼ�һ
		 * 
		 * 	�������ڵ�j����ʱ����i��buff��Ч������A[i] - (j - i) ==> A[i] + i - j 
		 * 	����һ�µ�ǰj��buff�������ĺ;�����һ�Ծ��۷����Ĺ�ʽ
		 * 
		 * 	���߼���
		 * */
		
		int buff = A[0];
		int ans = 0;
		for (int j = 1; j < A.length; j++) {
			buff--;
			ans = Math.max(ans, buff + A[j]);
			// ͬʱҪ�����ڵ�buff�����ṩ��buff�ĸ���ǿ
			buff = Math.max(buff, A[j]);
		}
		return ans;
	}
}
