package general_0000_0099;

public class _84_Largest_Rectangle_in_Histogram {
	
	/*
	 * 	����Ҳûզ�����˵�˼·
	 * 	������д��һ�·���
	 * 	��ÿһ���߶����������죬��¼������
	 * 	
	 * 	����������ʱ�临�Ӷȸ��͵Ľⷨ
	 * */
	
	public int largestRectangleArea(int[] heights) {		
		int area = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int left = i, right = i;

			while (left > 0 && heights[left - 1] >= height) {
				--left;
			}

			while (right + 1 < heights.length && heights[right + 1] >= height) {
				++right;
			}

			area = Math.max(area, (right - left + 1) * height);
		}
		return area;
    }
}