
public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {
	
	/*
	 * 	参考了题解中的一个二分法查找
	 * 	
	 * 	left 是矩阵的左上角
	 * 	right 是矩阵的右下角
	 * 	mid = (left + right) / 2
	 * 
	 * 	遍历当前的矩阵查看有多少小于mid值的
	 * 	如果count < k
	 * 		left = mid + 1
	 * 	count >= k
	 * 		right = mid
	 * 	二分的思路↑
	 * 	
	 * 	这里我修改了大佬写的findNotBiggerThanMid函数
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
