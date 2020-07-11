import java.util.LinkedList;
import java.util.List;

public class _315_Count_of_Smaller_Numbers_After_Self {
	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		List<Integer> ans = new LinkedList<>();
		if (nums.length == 0 || nums == null)
			return ans;
		ans.add(0);

		/*
		 * 	������е�ĳ���뷨����һ��
		 * 	���ǴӺ���ǰ�������飬�����һ��֮��ͰѺ���������Ÿ���
		 * 	����ǰ������Ϳ��Լ򵥵�ͳ�ƶ��ٸ�С������
		 * 
		 * 	��
		 * 	���������������Ҫÿ��ѭ����������
		 * 	�����ֱ�Ӹ��˴����������
		 * 	�Ѵ������ȫ����Ϊ��ǰ����������Ҳ�������������
		 * 	ͬʱҲ������Ѱ����С������������ĸ���
		 * */
		
//		for(int i = n - 2; i >= 0; i--) {
//			Arrays.sort(nums, i + 1, n);
//			// print(nums);
//			for(int j = i + 1; j < n; j++) {
//                if(nums[j] >= nums[i]) {
//                    ans.add(0, j - i - 1);
//                    break;
//                }
//                else if(j == n - 1) {
//                    ans.add(0, j - i);
//                    break; 
//                }
//            }
//		}

		for (int i = n - 2; i >= 0; i--) {
			int j = i + 1, temp = nums[i];
			while (j < n && nums[j] >= temp) {
				nums[j - 1] = nums[j];
				j++;
			}
			nums[j - 1] = temp;
			// n - j�ͱ�ʾ��������
			ans.add(0, n - j);
		}

		return ans;
	}
}
