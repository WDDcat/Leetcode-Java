package interview;

public class Interview_08_03_Magic_Index {
	
	/*
	 * 	����������Ѿ��ܼ���
	 * 	������Ϊ�ҵ���һЩ���������˼�
	 * 
	 * 	���ħ������������Ϊnums[i] == i
	 * 
	 * 	��ô�����������ͷ�����
	 * 	1�� nums[i] < i�� �������ֱ�ӽ�����һ�������Ϳ���
	 * 	2�� nums[i] > i�� ��nums[2] = 5�����������ǷǼ��ģ����ڶ��������Ѿ���5�����Ե������͵��ĸ�λ��һ��������
	 * 	��ʱ��������һ���ֱ����Ĺ���
	 * */
	
	public int findMagicIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				return i;
			}
			i = Math.max(i, nums[i] - 1);
		}
		return -1;
	}
}
