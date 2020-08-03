import java.util.Arrays;

public class _207_Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		/*
		 * 	���Ǽ���ͼ�����޻����㷨
		 * 	
		 * 	210������������
		 * 	��γ����Լ�д��һ��
		 * */
		
		// �洢��Щ�γ������
		boolean[] courses = new boolean[numCourses];
		// �洢��Щ�γ̹�ϵ������
		boolean[] useful = new boolean[prerequisites.length];
		Arrays.fill(courses, false);
		Arrays.fill(useful, true);

		for (int count = 0; count < numCourses; count++) {
			// �洢��ǰ��������Ϊ0 �Ŀγ�
			boolean[] canLearn = new boolean[numCourses];
			Arrays.fill(canLearn, true);
			// �ҵ����Ϊ��Ŀγ̱��
			for (int i = 0; i < prerequisites.length; i++) {
				if (useful[i]) {
					canLearn[prerequisites[i][1]] = false;
				}
			}
			// ����Щ��Ŷ�Ӧ�Ŀγ̱��Ϊ��ѧϰ
			for (int i = 0; i < canLearn.length; i++) {
				if (canLearn[i]) {
					courses[i] = true;
				}
			}
			// ����ѧϰ�Ŀγ̹�ϵ����Ϊ������
			for (int i = 0; i < prerequisites.length; i++) {
				if (canLearn[prerequisites[i][0]]) {
					useful[i] = false;
				}
			}
			// �ж��Ƿ����еĿγ̶������
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
