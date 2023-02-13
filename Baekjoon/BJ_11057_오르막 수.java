import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11057_OrmakSoo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[10][N];
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[j][i] += dp[k][i - 1];
					dp[j][i] %= 10007;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			ans += dp[i][N - 1];
			ans %= 10007;
		}
		System.out.println(ans);

	}

}
