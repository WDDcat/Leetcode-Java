
public class Interview_08_03_Magic_Index {
	public int findMagicIndex(int[] nums) {
		
		/*
		 * 	本身遍历就已经很简单了
		 * 	这里因为找到了一些规律又做了简化
		 * 
		 * 	这个魔术索引的条件为nums[i] == i
		 * 
		 * 	那么不满足的情况就分两种
		 * 	1： nums[i] < i， 这种情况直接进行下一个遍历就可以
		 * 	2： nums[i] > i， 如nums[2] = 5，由于数组是非减的，而第二个数就已经是5，所以第三个和第四个位置一定不满足
		 * 	这时可以跳过一部分遍历的过程
		 * */
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				return i;
			}
			i = Math.max(i, nums[i] - 1);
		}
		return -1;
	}
}
