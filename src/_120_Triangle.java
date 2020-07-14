import java.util.List;

public class _120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		/*
		 * 	�Լ���ģ��е�����dp
		 * 	����ÿһ�������ʱ��ȡ���ϻ����ϵ���Сֵ��ýڵ��ֵ���
		 * 	���ȡ�ײ���Сֵ�Ϳ���
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
