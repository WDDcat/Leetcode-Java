import java.util.List;

public class _120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		/*
		 * 	自己想的，有点类似dp
		 * 	就是每一层遍历的时候取左上或右上的最小值与该节点的值相加
		 * 	最后取底层最小值就可以
		 * */
		
		int n = triangle.size();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int cur = triangle.get(i).get(j);
				if (j == 0) {
					triangle.get(i).set(0, triangle.get(i - 1).get(0) + cur);
				} else if (j == i) {
					triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + cur);
				} else {
					int min = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
					triangle.get(i).set(j, min + cur);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, triangle.get(n - 1).get(i));
		}
		return min;
	}
}
