package general_0200_0299;
import java.util.ArrayList;
import java.util.List;

public class _210_Course_Schedule_II {
	
	/*
     *	1.��¼ÿ���ڵ����ȣ���¼ÿ���ڵ��ܹ�����Ľڵ�
     *	2.�����Ϊ��Ľڵ�洢��������
     *	3.�����ܹ�����Ľڵ�next�����-1
     *	4.�ظ�2.3
     */
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {		
		// �洢ĳ���ڵ����ܵ���������ڵ�ļ���
		List<Integer>[] lists = new ArrayList[numCourses];
		// ��¼ĳ���ڵ�����
		int[] points = new int[numCourses];

		// ��¼����
		for (int[] p : prerequisites) {
			points[p[0]]++;
			if (lists[p[1]] == null) {
				lists[p[1]] = new ArrayList<>();
			}
			lists[p[1]].add(p[0]);
		}

		// �������Ϊ���Ҵ�����next�ĵ�
		List<Integer> queue = new ArrayList<>();

		// �����������Ϊ��ĵ�
		for (int i = 0; i < numCourses; i++) {
			if (points[i] == 0) {
				queue.add(i);
			}
		}

		int[] result = new int[numCourses];
		int x = 0; // ��Ҫ��¼����ĵ������

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

		// x==numCoursesʱ����ʾ���еĵ㶼�Ѿ�����������򷵻ش������Ľ��
		return x == numCourses ? result : new int[0];
	}
}
