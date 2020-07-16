
public class _785_Is_Graph_Bipartite {
	
	/*
	 * 	判断是否为二分图的算法。
	 * 	学习了新的染色法：
	 * 	用两种颜色，对所有顶点逐个染色，且相邻顶点染不同的颜色，如果发现相邻顶点染了同一种颜色，就认为此图不为二分图。
	 * 	使用了dfs
	 * */
	
	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (color[i] == 0) {
				if (!dfs(graph, i, 1, color)) {
					return false;
				}
			}
		}
		return true;
	}

	boolean dfs(int[][] graph, int i, int c, int[] color) {
		color[i] = c;
		for (int n : graph[i]) {
			if (color[n] == c) {
				return false;
			}
			if (color[n] == 0 && !dfs(graph, n, -c, color)) {
				return false;
			}
		}
		return true;
	}
}
