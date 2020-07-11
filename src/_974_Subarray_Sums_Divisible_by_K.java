import java.util.HashMap;
import java.util.Map;

public class _974_Subarray_Sums_Divisible_by_K {
	public int subarraysDivByK(int[] A, int K) {
		/*
		 * 	����������ⶼ���Ҿ���
		 * 	ѧϰ�㷨�����Ҫ��ѧ����ĺ�
		 * 	
		 * 	�����Ǳ�������������ʱ�临�Ӷ�O(n^2)
		 * 
		 * 	����ȡģ�Ĳ�����Ҫ����һ��
		 * 	����ȡģ���ɸ�����������Ҫ�ټ�һ����������ȡģ
		 * 	
		 * 	Ȼ���Ǵ����㷨��
		 * 	��һ����ϣ��� <  �������������˵��ÿһ������,   ÿһ�ֱ���������ܺ͵�ģ��  >
		 * 	�� [4, 5, 0] K = 5
		 * 	��ϣ��ĳ�ʼֵΪ ��0->0, 1->0, 2->0, 3->0, 4->0��
		 * 	������һ������ʱ�� sum = 4 mod = 4  ��ϣ����ģ4��ֵΪ0
		 * 	�����ڶ�������ʱ�� sum = 9 mod = 4	��ϣ����ģ4��ֵΪ1  -->   ans + 1 ����Ϊ�����ģ4��λ�õ���һ��ģ4��λ���м�����������һ������������
		 * 	��������������ʱ�� sum = 9 mod = 4  ��ϣ����ģ4��ֵΪ2  -->   ans + 2 ����Ϊ�����ģ4��λ�õ�������ģ4��λ���м�������鶼��������
		 * 	����˵���Ǽ�������ģ��ͬ��λ��֮����ӵ���������������
		 * 	��������Ĺ��̼����˱����Ĺ�����
		 * */
//		int sum = 0;
//		int count = 0;
//		for(int i = 0; i < A.length; i++) {
//			sum = 0;
//			for(int j = i; j < A.length; j++) {
//				sum += A[j];
//				if((sum % K + K) % K == 0)
//					count++;
//			}
//		}
//		return count;
		
		Map<Integer, Integer> record = new HashMap<>();
		record.put(0, 1);
		int sum = 0, ans = 0;
		for (int num : A) {
			sum += num;
			int mod = (sum % K + K) % K;
			int same = record.getOrDefault(mod, 0);
			ans += same;
			record.put(mod, same + 1);
		}
		return ans;
	}
}
