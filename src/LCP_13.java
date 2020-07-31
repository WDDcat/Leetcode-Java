import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCP_13 {
	
	/*	Ӧ�üӸ��ѶȽ�������
	 * 	
	 * 	���˼·�����������stone�ĸ��������̾��루button��stone��button��
	 * 	Ȼ��������е��߷������ҵ����·��
	 * 	
	 * 	������Ҫ����������Ĵ���
	 * 	������·���ľ���Ҳ�Ǹ�������
	 * */
	
	int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int n, m;

	public int minimalSteps(String[] maze) {
		n = maze.length;
		m = maze[0].length();

		List<int[]> buttons = new ArrayList<>();
		List<int[]> stones = new ArrayList<>();

		int sx = -1, sy = -1, tx = -1, ty = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				switch (maze[i].charAt(j)) {
				case 'M':
					buttons.add(new int[] { i, j });
					break;
				case 'O':
					stones.add(new int[] { i, j });
					break;
				case 'S':
					sx = i;
					sy = j;
					break;
				case 'T':
					tx = i;
					ty = j;
					break;
				}
			}
		}
		int nb = buttons.size();
		int ns = stones.size();
		int[][] startDist = bfs(sx, sy, maze);

		// û�л��ص����
		if (nb == 0) {
			return startDist[tx][ty];
		}

		// ��buttons�е�i�����ص� ���������أ�;��button����������㣨;��button���������յ㡱�ľ���
		int[][] buttonDist = new int[nb][nb + 2];
		for (int[] array : buttonDist) {
			Arrays.fill(array, -1);
		}
		// ����buttonDist
		int[][][] dists = new int[nb][][]; // �洢ÿ���ڵ�ļ�����
		for (int i = 0; i < nb; i++) {
			dists[i] = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
			// �����յ㲻��Ҫ����button
			buttonDist[i][nb + 1] = dists[i][tx][ty];
		}
		for (int i = 0; i < nb; i++) {
			// ��������stone->button
			int s2b = -1;
			// ����ĳ�ʼֵ������ΪInteger.MAX_VALUE��ԭ��Ϊ���û�м����ͨ·������Ҫ���-1
			// ��������ͬ��
			for (int j = 0; j < ns; j++) {
				int stonex = stones.get(j)[0], stoney = stones.get(j)[1];
				if (dists[i][stonex][stoney] != -1 && startDist[stonex][stoney] != -1) { // ����ͨ·
					if (s2b == -1 || s2b > startDist[stonex][stoney] + dists[i][stonex][stoney]) {
						s2b = startDist[stonex][stoney] + dists[i][stonex][stoney];
					}
				}
			}
			buttonDist[i][nb] = s2b;

			// ����button��stone��button
			for (int j = i + 1; j < nb; j++) {
				// ����ÿ��button,���������s2b��ͬ
				int b2b = -1;
				for (int k = 0; k < ns; k++) {
					int stonex = stones.get(k)[0], stoney = stones.get(k)[1];
					if (dists[i][stonex][stoney] != -1 && dists[j][stonex][stoney] != -1) { // ����ͨ·
						if (b2b == -1 || b2b > dists[i][stonex][stoney] + dists[j][stonex][stoney]) {
							b2b = dists[i][stonex][stoney] + dists[j][stonex][stoney];
						}
					}
				}
				buttonDist[i][j] = b2b;
				buttonDist[j][i] = b2b;
			}
		}

		// ��ĳһbutton�޷����� start��end �����
		for (int i = 0; i < nb; i++) {
			if (buttonDist[i][nb] == -1 || buttonDist[i][nb + 1] == -1) {
				return -1;
			}
		}

		// maskΪ16λ�����Ʊ�ʾÿ��button�Ĵ���״̬
		// dp(mask, i) ��ʾ��i��M ʱ ����״̬mask����С����
		// dp(mask, i) = min{dp(mask xor 2^i, j) + dist(i, j)} (j != i && j �� �Ѵ�����)
		int[][] dp = new int[1 << nb][nb];
		for (int[] array : dp) {
			Arrays.fill(array, -1);
		}
		// ��ʼ����start����һ��button�����
		for (int i = 0; i < nb; i++) {
			dp[1 << i][i] = buttonDist[i][nb];
		}
		// �Ƶ�dp
		for (int mask = 1; mask < (1 << nb); mask++) {
			for (int i = 0; i < nb; i++) {
				// �ж�dp�Ϸ�
				if ((mask & (1 << i)) != 0) {
					for (int j = 0; j < nb; j++) {
						// j����mask��
						if ((mask & (1 << j)) == 0) {
							int next = mask | (1 << j);
							if (dp[next][j] == -1) {
								dp[next][j] = dp[mask][i] + buttonDist[i][j];
							}
							dp[next][j] = Math.min(dp[next][j], dp[mask][i] + buttonDist[i][j]);
						}
					}
				}
			}
		}

		int ans = -1;
		int finalMask = (1 << nb) - 1; // ȫ1����
		for (int i = 0; i < nb; i++) {
			if (ans == -1 || ans > dp[finalMask][i] + buttonDist[i][nb + 1]) {
				ans = dp[finalMask][i] + buttonDist[i][nb + 1];
			}
		}
		return ans;
	}

	// ���ڲ���(x,y)����ÿһ�������̾���
	int[][] bfs(int x, int y, String[] maze) {
		int[][] ret = new int[n][m];
		for (int[] array : ret) {
			Arrays.fill(array, -1);
		}
		ret[x][y] = 0;
		// �������д洢�����Ѿ��������Ľڵ�
		Queue<int[]> queue = new LinkedList<>();
		// offer��poll��������add��remove������ֹ��ʧ�ܵ�ʱ���׳��쳣
		queue.offer(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int curx = pos[0], cury = pos[1];
			for (int i = 0; i < 4; i++) {
				int newx = curx + dir[i][0], newy = cury + dir[i][1];
				if (inBound(newx, newy) && maze[newx].charAt(newy) != '#' && ret[newx][newy] == -1) {
					ret[newx][newy] = ret[curx][cury] + 1;
					queue.offer(new int[] { newx, newy });
				}
			}
		}
		return ret;
	}

	boolean inBound(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}
