import java.util.Arrays;

public class _174_Dungeon_Game {
	public int calculateMinimumHP(int[][] dungeon) {

		// dp[i][j]=max(min(dp[i+1][j],dp[i][j+1])−dungeon(i,j),1)

		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 0; i <= row; ++i) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		dp[row][col - 1] = dp[row - 1][col] = 1;
		for (int i = row - 1; i >= 0; --i) {
			for (int j = col - 1; j >= 0; --j) {
				int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = Math.max(min - dungeon[i][j], 1);
			}
		}
		return dp[0][0];
	}
}
