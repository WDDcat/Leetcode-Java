public class JianZhi_Offer_29 {
	public int[] spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
		/*
		 * 	1  2  3  4
		 * 	5  6  7  8
		 *  9 10 11 12
		 * 13 14 15 16 
		 * */
		
		/*
		 * 	特别难受昨天忘了打卡
		 * 	这题就没啥数据结构上的困难，就逻辑处理好了就完事
		 * */
		
		int width = matrix[0].length;
		int height = matrix.length;
		int total = width * height;
		int[] ans = new int[total];
		int curRow = 0, curCol = 0;
		int direction = 1; // 1-->右 2-->下 3-->左 4-->上
		int minRow = 0, maxRow = height - 1;
		int minCol = 0, maxCol = width - 1;
		for (int i = 0; i < total; i++) {
			ans[i] = matrix[curRow][curCol];
			switch (direction) {
			case 1:
				if (curCol == maxCol) {
					direction = 2;
					curRow++;
					minRow++;
				} else {
					curCol++;
				}
				break;
			case 2:
				if (curRow == maxRow) {
					direction = 3;
					curCol--;
					maxCol--;
				} else {
					curRow++;
				}
				break;
			case 3:
				if (curCol == minCol) {
					direction = 4;
					curRow--;
					maxRow--;
				} else {
					curCol--;
				}
				break;
			case 4:
				if (curRow == minRow) {
					direction = 1;
					curCol++;
					minCol++;
				} else {
					curRow--;
				}
				break;
			}
		}

		return ans;
	}
}
