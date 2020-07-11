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
		 * 	与题解中的某个想法基本一致
		 * 	就是从后往前处理数组，处理过一个之后就把后面的数组排个序
		 * 	这样前面的数就可以简单的统计多少个小于他的
		 * 
		 * 	但
		 * 	我做的这个就是需要每次循环经历排序
		 * 	而题解直接改了处理过的数组
		 * 	把处理的数全部改为当前的数，这样也起到了排序的作用
		 * 	同时也遍历并寻找了小于这个数的数的个数
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
			// n - j就表示计数个数
			ans.add(0, n - j);
		}

		return ans;
	}
}
