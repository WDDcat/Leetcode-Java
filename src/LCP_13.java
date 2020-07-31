import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCP_13 {
	
	/*	应该加个难度叫做极难
	 * 	
	 * 	大概思路就是算出经过stone的各个点的最短距离（button→stone→button）
	 * 	然后遍历所有的走法排列找到最短路径
	 * 	
	 * 	其中需要做特殊情况的处理
	 * 	而且求路径的距离也是个技术活
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

		// 没有机关的情况
		if (nb == 0) {
			return startDist[tx][ty];
		}

		// 从buttons中第i个机关到 “其他机关（途径button）”，“起点（途径button）”，“终点”的距离
		int[][] buttonDist = new int[nb][nb + 2];
		for (int[] array : buttonDist) {
			Arrays.fill(array, -1);
		}
		// 计算buttonDist
		int[][][] dists = new int[nb][][]; // 存储每个节点的计算结果
		for (int i = 0; i < nb; i++) {
			dists[i] = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
			// 到达终点不需要经过button
			buttonDist[i][nb + 1] = dists[i][tx][ty];
		}
		for (int i = 0; i < nb; i++) {
			// 计算起点→stone->button
			int s2b = -1;
			// 这里的初始值不设置为Integer.MAX_VALUE的原因为如果没有计算出通路，则需要添加-1
			// 后面的情况同理
			for (int j = 0; j < ns; j++) {
				int stonex = stones.get(j)[0], stoney = stones.get(j)[1];
				if (dists[i][stonex][stoney] != -1 && startDist[stonex][stoney] != -1) { // 存在通路
					if (s2b == -1 || s2b > startDist[stonex][stoney] + dists[i][stonex][stoney]) {
						s2b = startDist[stonex][stoney] + dists[i][stonex][stoney];
					}
				}
			}
			buttonDist[i][nb] = s2b;

			// 计算button→stone→button
			for (int j = i + 1; j < nb; j++) {
				// 遍历每个button,方法与计算s2b相同
				int b2b = -1;
				for (int k = 0; k < ns; k++) {
					int stonex = stones.get(k)[0], stoney = stones.get(k)[1];
					if (dists[i][stonex][stoney] != -1 && dists[j][stonex][stoney] != -1) { // 存在通路
						if (b2b == -1 || b2b > dists[i][stonex][stoney] + dists[j][stonex][stoney]) {
							b2b = dists[i][stonex][stoney] + dists[j][stonex][stoney];
						}
					}
				}
				buttonDist[i][j] = b2b;
				buttonDist[j][i] = b2b;
			}
		}

		// 从某一button无法到达 start或end 的情况
		for (int i = 0; i < nb; i++) {
			if (buttonDist[i][nb] == -1 || buttonDist[i][nb + 1] == -1) {
				return -1;
			}
		}

		// mask为16位二进制表示每个button的触发状态
		// dp(mask, i) 表示第i个M 时 触发状态mask的最小步数
		// dp(mask, i) = min{dp(mask xor 2^i, j) + dist(i, j)} (j != i && j ∈ 已触发的)
		int[][] dp = new int[1 << nb][nb];
		for (int[] array : dp) {
			Arrays.fill(array, -1);
		}
		// 初始化从start到第一个button的情况
		for (int i = 0; i < nb; i++) {
			dp[1 << i][i] = buttonDist[i][nb];
		}
		// 推导dp
		for (int mask = 1; mask < (1 << nb); mask++) {
			for (int i = 0; i < nb; i++) {
				// 判断dp合法
				if ((mask & (1 << i)) != 0) {
					for (int j = 0; j < nb; j++) {
						// j不在mask中
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
		int finalMask = (1 << nb) - 1; // 全1序列
		for (int i = 0; i < nb; i++) {
			if (ans == -1 || ans > dp[finalMask][i] + buttonDist[i][nb + 1]) {
				ans = dp[finalMask][i] + buttonDist[i][nb + 1];
			}
		}
		return ans;
	}

	// 用于测量(x,y)点至每一个点的最短距离
	int[][] bfs(int x, int y, String[] maze) {
		int[][] ret = new int[n][m];
		for (int[] array : ret) {
			Arrays.fill(array, -1);
		}
		ret[x][y] = 0;
		// 建立队列存储广搜已经搜索过的节点
		Queue<int[]> queue = new LinkedList<>();
		// offer和poll用来代替add和remove方法防止在失败的时候抛出异常
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
