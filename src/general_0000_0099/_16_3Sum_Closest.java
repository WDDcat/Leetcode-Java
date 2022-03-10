package general_0000_0099;
import java.util.Arrays;

public class _16_3Sum_Closest {
	
	/*
	 * 	��������Ԫ����ⶼ��Ҫ�õ�  ��������+˫ָ��
	 * 	�������15������ƣ�ֻ����һ������0��һ������Ŀ��ֵ
	 * 	��΢��һ�ľͿ�����
	 * 	
	 * 	����˫ָ�뻹��û���Լ�д�������´���ȡ�Լ�д
	 * */
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int big = 10000;
		int small = -10000;
		int n = nums.length;
		for (int i = 0; i < n; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int L = i + 1, R = n - 1;
			while (L < R) {
				int cur = nums[i] + nums[L] + nums[R];
				if (cur - target == 0) {
					return cur;
				} else if (cur < target) {
					if (small < cur)
						small = cur;
					L++;
				} else {
					if (big > cur)
						big = cur;
					R--;
				}
			}
		}
		if (Math.abs(small - target) < Math.abs(big - target))
			return small;
		return big;
	}
}
