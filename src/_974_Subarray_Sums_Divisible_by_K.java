import java.util.HashMap;
import java.util.Map;

public class _974_Subarray_Sums_Divisible_by_K {
	public int subarraysDivByK(int[] A, int K) {
		/*
		 * 	连续两天的题都让我觉得
		 * 	学习算法真的需要数学格外的好
		 * 	
		 * 	首先是笨方法，暴力解时间复杂度O(n^2)
		 * 
		 * 	其中取模的操作需要处理一下
		 * 	负数取模会变成负数，所以需要再加一个除数后再取模
		 * 	
		 * 	然后是大神算法：
		 * 	用一个哈希表存 <  对于这个除数来说的每一个余数,   每一轮遍历求出的总和的模数  >
		 * 	例 [4, 5, 0] K = 5
		 * 	哈希表的初始值为 【0->0, 1->0, 2->0, 3->0, 4->0】
		 * 	遍历第一个数的时候 sum = 4 mod = 4  哈希表中模4的值为0
		 * 	遍历第二个数的时候 sum = 9 mod = 4	哈希表中模4的值为1  -->   ans + 1 是因为从这个模4的位置到上一个模4的位置中间的子数组就是一个符合条件的
		 * 	遍历第三个数的时候 sum = 9 mod = 4  哈希表中模4的值为2  -->   ans + 2 是因为从这个模4的位置到上两个模4的位置中间的子数组都符合条件
		 * 	简单来说就是计算所有模相同的位置之间夹杂的子数组的排列组合
		 * 	不过计算的过程夹在了遍历的过程中
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
