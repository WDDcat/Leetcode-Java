import java.util.Arrays;

public class _41_First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
		
		/*
		 * 	����˵����Ҫʱ��O(n)�ҿռ�����
		 * 	�ٷ����Ľⷨ��ֱ̫������
		 * 
		 *	���ֽⷨ
		 *	�ĸ��ݾ���
		 *	������鳤Ϊn����ôҪô��������Ϊ[1,2,...,n]��������ֵΪ��n+1���� Ҫô���м���һ���ȱ����ֻ�������ڲ������¾Ϳ�����
		 *
		 *	1. ��ϣ��
		 *	���Ƚ�<0�����Ϊn+1
		 *	����n�����Ӧ��λ����Ϊ����  �磺nums[0] = 3 �� nums[3 - 1] = -abs(nums[3 - 1])
		 *	������ֻҪ��xλ���ڹ�����һλ��Ӧ�����־��Ǹ���
		 *	�ҵ���һ��������Ӧ���±�+1 || n+1 
		 *
		 *	2.�û�
		 *	��ĳ�����龡���û�Ϊ[1,2,...,n]
		 *	��Ȼ�����ȱʧ��(<=0)����յ�
		 *	������һ������λ���ϵ�������ȱʧ����
		 **/

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}
	
	/*
	 * if(nums == null || nums.length == 0) return 1;
        
        Arrays.sort(nums);
		
		int i = 0;
		while(i < nums.length && nums[i] <= 0) {
			i++;
		}
		System.out.println(i);
		int last = 0;
		while(i < nums.length) {
			if(nums[i] - last > 1) return (last + 1);
            last = nums[i];
			i++;
		}
		return (nums[nums.length - 1] + 1) > 0 ? nums[nums.length - 1] + 1 : 1;
	 * */
}
