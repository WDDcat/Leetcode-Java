
public class _4_Median_of_Two_Sorted_Arrays {
	
	/*
	 * 	һ��ʼ������һ��˼·�����Ǵ���һ�������ܹ������������飬��������֮��ֱ�ӾͿ��������λ����
	 * 	�������������ķ����ڴ����ķǳ��󣬾����ܲ���ʹ�������ƶ�ָ��ķ�ʽά����ǰ����Сֵ��
	 * 
	 * 	��������ص�����
	 * 	1. ��ż���鳤�ȶ�Ӧ����λ���󷨲�ͬ��
	 * 	2. �����һ�������Ѿ�������������һ�����кܳ��������
	 * 	
	 * 	��һ����Ϊ����ʵ�֣����ѡ����ʱ�临�ӶȽϸߵ��������м�ֵ�ķ�����
	 * 	�ڶ�������Ļ�����Ҫʹ��һ������ѭ���������һ��needToCount��������¼���账�������������
	 * 	----ͬʱ������ָ���Ѿ�ָ�������β����������жϡ�
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
