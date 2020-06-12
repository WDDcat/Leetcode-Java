import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		
		/*
		 * 	����ʶ�뵽����ѭ����Ȼ����뵽һ���ᳬʱ
		 * 	�������ֲ����ᳬʱ����������ظ���
		 * 	�뵽������Ȼ���ظ��ľ�continue i++
		 * 
		 * 	�������ǲ���
		 * 	���ǿ������
		 * 	
		 * 	�����������˼Ӻ͵���0ʱһ����һ����ɸ����һ��ֵ���������
		 * 	˫ָ�������˼Ӻ����Դ��������м����
		 * 	�
		 * */
		
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			if(nums[i] > 0) return ans;
			
			if(i > 0 && nums[i] == nums[i-1]) continue;
			
			int L = i+1, R = n-1;
			while(L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if(sum == 0) {
					List<Integer> unit = new ArrayList<>();
					unit.add(nums[i]);
					unit.add(nums[L]);
					unit.add(nums[R]);
					ans.add(unit);
					
					while(L<R && nums[L+1] == nums[L]) L++;
					while(L<R && nums[R-1] == nums[R]) R--;
					
					L++;
					R--;
				}
				else if(sum < 0) {
					L++;
				}
				else {
					R--;
				}
			}
		}
		return ans;
    }
}
