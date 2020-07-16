
public class _785_Is_Graph_Bipartite {
	
	/*
	 * 	�ж��Ƿ�Ϊ����ͼ���㷨��
	 * 	ѧϰ���µ�Ⱦɫ����
	 * 	��������ɫ�������ж������Ⱦɫ�������ڶ���Ⱦ��ͬ����ɫ������������ڶ���Ⱦ��ͬһ����ɫ������Ϊ��ͼ��Ϊ����ͼ��
	 * 	ʹ����dfs
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
