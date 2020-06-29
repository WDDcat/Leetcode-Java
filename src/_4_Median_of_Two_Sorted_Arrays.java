
public class _4_Median_of_Two_Sorted_Arrays {
	
	/*
	 * 	一开始我想了一个思路，就是创建一个数组能够整合两个数组，这样整合之后直接就可以求出中位数。
	 * 	后来发现这样的方法内存消耗非常大，就想能不能使用两个移动指针的方式维护当前的最小值。
	 * 
	 * 	但问题的重点在于
	 * 	1. 奇偶数组长度对应的中位数求法不同。
	 * 	2. 会出现一个数组已经遍历结束，另一个还有很长的情况。
	 * 	
	 * 	第一个较为容易实现，最后选择了时间复杂度较高的求两次中间值的方法。
	 * 	第二个问题的话，需要使用一个永久循环，并添加一个needToCount变量，记录还需处理的数的数量。
	 * 	----同时对两种指针已经指到数组结尾的情况进行判断。
	 * */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
		int l1 = nums1.length, l2 = nums2.length;
		if((l1 + l2) % 2 == 1) {
			int needToCount = (l1 + l2) / 2 + 1;
			return findMiddle(nums1, nums2, needToCount);
		}
		else {
			int needToCount = (l1 + l2) / 2;
			return (findMiddle(nums1, nums2, needToCount) + findMiddle(nums1, nums2, needToCount + 1)) / 2.0;
		}
    }
	
	public double findMiddle(int[] nums1, int[] nums2, int needToCount) {
		int p1 = 0, p2 = 0;
		int l1 = nums1.length, l2 = nums2.length;
		
		while(true) {
			if(p1 == l1) {
				return nums2[p2 + needToCount - 1];
			}
			if(p2 == l2) {
				return nums1[p1 + needToCount - 1];
			}
			if(needToCount == 1) {
				return Math.min(nums1[p1], nums2[p2]);
			}
			
			int num1 = nums1[Math.min(p1, l1)];
			int num2 = nums2[Math.min(p2, l2)];
			if(num1 <= num2) {
				needToCount--;
				p1 = Math.min(p1, l1) + 1;
			}
			else {
				needToCount--;
				p2 = Math.min(p2, l2) + 1;
			}
		}
	}
}
