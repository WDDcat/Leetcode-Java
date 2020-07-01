
public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {
	
	/*
	 * 	�ο�������е�һ�����ַ�����
	 * 	
	 * 	left �Ǿ�������Ͻ�
	 * 	right �Ǿ�������½�
	 * 	mid = (left + right) / 2
	 * 
	 * 	������ǰ�ľ���鿴�ж���С��midֵ��
	 * 	���count < k
	 * 		left = mid + 1
	 * 	count >= k
	 * 		right = mid
	 * 	���ֵ�˼·��
	 * 	
	 * 	�������޸��˴���д��findNotBiggerThanMid����
	 * 	*/
	
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int left = matrix[0][0];
		int right = matrix[n - 1][n - 1];
		while(left < right) {
			int mid = (left + right) / 2;
			int count = findNotBiggerThanMid(matrix, mid, n);
			if(count < k) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return right;
    }
	
	int findNotBiggerThanMid(int[][] matrix, int mid, int length) {
		int count = 0;
		for(int i = 0; i < length; i++) {
			int j = length - 1;
			while(matrix[i][j] > mid) {
				j--;
			}
			count += j + 1;
		}
		return count;
	}
}
