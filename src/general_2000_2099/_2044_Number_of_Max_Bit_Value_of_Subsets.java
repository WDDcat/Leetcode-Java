package general_2000_2099;

public class _2044_Number_of_Max_Bit_Value_of_Subsets {
	
	/*
	 * ����һ���֣����ĳһ�����ۣ����Э��һ���Ƚ��еȵĴ�
	 * 
	 * 1. ������������ ������ �ĺ�
	 * 
	 * 2. 	���� dfs
	 * 		�ֱ�ӵ����Ԫ�ر������� n-1 ��Ԫ��
	 * 		ѡ��Ҫ��Ҫ
	 * 		����� n ��ʱ���жϻ�����ĺ��������� maxValue 
	 * 
	 * 	[2,  1,  1]
	 *   0 - 0 - 0 
	 *     |   \ 1
	 *     \ 1 - 0
	 *         \ 1
	 *         
	 *         
	 *  �����һ���������ʱ�䣬���һ��ʼ����Ĳ���ʡ�ԣ����ڵݹ�Ĺ�����
	 *  �������ֺ����ڵݹ���õĹ����м���Ĵ��������������
	 *  �����ͷ�������һ�뷨��
	 * */
	
	public int countMaxOrSubsets(int[] nums) {
		int max = 0;
	    for(int num : nums) {
	        max |= num;
	    }
		return dfs(0, nums, 0, max);
    }
	
	private int dfs(int curIndex, int[] nums, int curValue, int max) {
		if(curIndex == nums.length) {
			return curValue == max ? 1 : 0;
		}
		return (dfs(curIndex + 1, nums, curValue, max)) 
				+ (dfs(curIndex + 1, nums, curValue | nums[curIndex], max));
	}
}
