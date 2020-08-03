import java.util.Arrays;

public class _207_Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		/*
		 * 	就是检验图中有无环的算法
		 * 	
		 * 	210题和这个很相似
		 * 	这次尝试自己写了一个
		 * */
		
		// 存储哪些课程完成了
		boolean[] courses = new boolean[numCourses];
		// 存储哪些课程关系还有用
		boolean[] useful = new boolean[prerequisites.length];
		Arrays.fill(courses, false);
		Arrays.fill(useful, true);

		for (int count = 0; count < numCourses; count++) {
			// 存储当前情况下入度为0 的课程
			boolean[] canLearn = new boolean[numCourses];
			Arrays.fill(canLearn, true);
			// 找到入度为零的课程编号
			for (int i = 0; i < prerequisites.length; i++) {
				if (useful[i]) {
					canLearn[prerequisites[i][1]] = false;
				}
			}
			// 把这些编号对应的课程标记为已学习
			for (int i = 0; i < canLearn.length; i++) {
				if (canLearn[i]) {
					courses[i] = true;
				}
			}
			// 将已学习的课程关系设置为不可用
			for (int i = 0; i < prerequisites.length; i++) {
				if (canLearn[prerequisites[i][0]]) {
					useful[i] = false;
				}
			}
			// 判断是否所有的课程都完成了
			boolean finish = true;
			for (int i = 0; i < numCourses; i++) {
				if (!courses[i]) {
					finish = false;
					break;
				}
			}
			if (finish) {
				return true;
			}
		}
		return false;
	}
}
