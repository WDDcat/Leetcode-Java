
public class _84LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		/*
		 * 	这题也没咋看别人的思路
		 * 	就试着写了一下方法
		 * 	用每一个高度向两侧延伸，记录最大面积
		 * 	
		 * 	题解里好像有时间复杂度更低的解法*/
		
		int area = 0;
		for(int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int left = i, right = i;
			
			while(left > 0 && heights[left - 1] >= height) {
				--left;
			}
			
			while(right + 1 < heights.length && heights[right + 1] >= height) {
				++right;
			}
			
			area = Math.max(area, (right - left + 1) * height);
		}
		return area;
    }
}
