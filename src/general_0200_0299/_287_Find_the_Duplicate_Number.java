package general_0200_0299;

public class _287_Find_the_Duplicate_Number {
	
	/*
	 * 	缘分妙不可言
	 * 	这题真是太有意思了，可能就算我已经做过一遍，再做还是不知道…
	 * 
	 * 	假设数组为[1, 3, 4, 2, 2]
	 * 		   0  1  2  3  4
	 * 	利用数组下标结合数组内容可得到一条链
	 * 	0->1 1->3, 3->2 2->4 4->2
	 * 	发现有环，则循环入口的2就是重复的数字
	 * 	
	 * 	用两个指针，起名为快慢指针
	 * 	一个指针只往后寻找一步
	 * 	另一个指针往后寻找两步
	 * 	两个指针总会在某一刻相遇（好浪漫）
	 * 
	 * 	然后再给零一个指针还原
	 * 	让他们再相遇一次
	 * 	有人证明了他们一定会在入口处相遇
	 * */
	
	public int findDuplicate(int[] nums) {
		if (nums.length <= 2) {
			return nums[0];
		}

		int i = 0, j = 0;
		while (true) {
			i = nums[i];
			j = nums[nums[j]];
			if (i == j)
				break;
		}

		i = 0;
		while (true) {
			i = nums[i];
			j = nums[j];
			if (i == j)
				break;
		}
		return i;
	}
}
