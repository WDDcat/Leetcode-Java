
public class _410_Split_Array_Largest_Sum {
	
	/*	��ȡ������е�һ����˵����
	 * 
	 * 	�����У�����ע�⵽��
	 * 	������ѡ��һ��ֵ x�����ǿ������Ե���֤�Ƿ����һ�ַָ����
	 * 	���������ָ�������Ͳ����� x��
	 * 	�������£�
	 * 
	 * 	̰�ĵ�ģ��ָ�Ĺ��̣���ǰ����������飬��sum ��ʾ��ǰ�ָ�������ĺͣ�
	 * 	cnt ��ʾ�Ѿ��ָ�����������������������ǰ�����飩
	 * 	��ôÿ��sum ���ϵ�ǰֵ������ x��
	 * 	���ǾͰѵ�ǰȡ��ֵ��Ϊ�µ�һ�ηָ�������Ŀ�ͷ��
	 * 	����cnt �� 1��
	 * 	������������֤�Ƿ�cnt������m��
	 * 
	 * 	�������ǿ����ö��ֲ����������
	 * 	���ֵ��Ͻ�Ϊ���� nums������Ԫ�صĺͣ�
	 * 	�½�Ϊ���� nums������Ԫ�ص����ֵ
	 * 	ͨ�����ֲ��ң����ǿ��Եõ���С�����ָ�������ͣ������Ϳ��Եõ����յĴ��ˡ�
	 * */
	
	public int splitArray(int[] nums, int m) {
		int min = 0;
		int max = 0;

		// ��ʼ�����ֱ߽�
		for (int n : nums) {
			max += n;
			if (min < n) {
				min = n;
			}
		}

		// �����ֵ���ж��ֲ���
		while (min < max) {
			int mid = (max - min) / 2 + min;
			if (check(nums, m, mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	// ̰�Ĳ��Ҳ������ֵ����Сֵ
	boolean check(int[] nums, int m, int x) {
		int sum = 0;
		int cnt = 1;
		for (int n : nums) {
			if (n + sum <= x) {
				sum += n;
			} else {
				cnt++;
				sum = n;
			}
		}
		return cnt <= m;
	}
}
