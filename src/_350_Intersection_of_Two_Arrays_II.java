import java.util.Arrays;
import java.util.HashMap;

public class _350_Intersection_of_Two_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
		
		/*
		 * 	还是不争气看了题解
		 * 	不过有优化一下，把第二个创建的数组去掉了，直接用了当前的一个数组
		 * */
		
		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums1) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		int index = 0;
		for (int num : nums2) {
			int count = map.getOrDefault(num, 0);
			if (count > 0) {
				nums2[index++] = num;
				map.put(num, count - 1);
			}
		}
		return Arrays.copyOfRange(nums2, 0, index);
	}
}
