import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2342_DanceDanceRevolution {

	static int[][] cal;
	static int[][][] dp;
	static int N;
	static int[] points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = 0;
		points = new int[100001];
		while (st.hasMoreTokens()) {
			int point = Integer.parseInt(st.nextToken());
			points[N] = point;
			N++;
			if (point == 0)
				break;
		}
		dp = new int[N][5][5];
		cal = new int[5][5];
		// 각 지점 이동별 칼로리 소모양
		cal[0][1] = 2;
		cal[0][2] = 2;
		cal[0][3] = 2;
		cal[0][4] = 2;
		cal[1][1] = 1;
		cal[1][2] = 3;
		cal[1][3] = 4;
		cal[1][4] = 3;
		cal[2][1] = 3;
		cal[2][2] = 1;
		cal[2][3] = 3;
		cal[2][4] = 4;
		cal[3][1] = 4;
		cal[3][2] = 3;
		cal[3][3] = 1;
		cal[3][4] = 3;
		cal[4][1] = 3;
		cal[4][2] = 4;
		cal[4][3] = 3;
		cal[4][4] = 1;
		int ans = step(0, 0, 0);
		System.out.println(ans);

	}

	private static int step(int count, int left, int right) {
		if (count == N - 1)
			return 0;

		if (dp[count][left][right] != 0) {
			return dp[count][left][right];
		}

		int leftStep = cal[left][points[count]] + step(count + 1, points[count], right);
		int rightStep = cal[right][points[count]] + step(count + 1, left, points[count]);

		return dp[count][left][right] = Math.min(leftStep, rightStep);
	}

}
