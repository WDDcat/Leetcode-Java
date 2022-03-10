package general_0200_0299;
import java.util.ArrayList;
import java.util.List;

public class _210_Course_Schedule_II {
	
	/*
     *	1.记录每个节点的入度，记录每个节点能够到达的节点
     *	2.将入度为零的节点存储进队列中
     *	3.将它能够到达的节点next的入度-1
     *	4.重复2.3
     */
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {		
		// 存储某个节点所能到达的其他节点的集合
		List<Integer>[] lists = new ArrayList[numCourses];
		// 记录某个节点的入度
		int[] points = new int[numCourses];

		// 记录数据
		for (int[] p : prerequisites) {
			points[p[0]]++;
			if (lists[p[1]] == null) {
				lists[p[1]] = new ArrayList<>();
			}
			lists[p[1]].add(p[0]);
		}

		// 储存入度为零且待处理next的点
		List<Integer> queue = new ArrayList<>();

		// 遍历查找入度为零的点
		for (int i = 0; i < numCourses; i++) {
			if (points[i] == 0) {
				queue.add(i);
			}
		}

		int[] result = new int[numCourses];
		int x = 0; // 需要记录处理的点的数量

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int p = queue.get(0);
				result[x++] = p;
				queue.remove(0);

				List<Integer> list = lists[p];
				if (list == null)
					continue;
				for (int i : list) {
					points[i]--;
					if (points[i] == 0) {
						queue.add(i);
					}
				}
			}
		}

		// x==numCourses时，表示所有的点都已经被处理过，则返回处理过后的结果
		return x == numCourses ? result : new int[0];
	}
}
