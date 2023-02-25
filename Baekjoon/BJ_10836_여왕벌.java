import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10836_QueenBee {
	static int M, N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][M];
		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], 1);
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			if (zero <= M) {
				if (zero + one <= M) {
					for (int j = M - zero - 1; j >= M - zero - one; j--) {
						map[j][0] += 1;
					}
					for (int j = M - zero - one - 1; j >= 0; j--) {
						map[j][0] += 2;
					}
					for (int j = 1; j < M; j++) {
						map[0][j] += 2;
					}
				} else {
					for (int j = M - zero - 1; j >= 0; j--) {
						map[j][0] += 1;
						one--;
					}
					for (int j = 1; j <= one; j++) {
						map[0][j] += 1;
					}
					for (int j = one + 1; j < M; j++) {
						map[0][j] += 2;
					}
				}
			} else {
				for (int j = zero - M + 1; j < zero - M + 1 + one; j++) {
					map[0][j] += 1;
				}
				for (int j = zero - M + 1 + one; j < M; j++) {
					map[0][j] += 2;
				}
			}

		}
		for (int j = 1; j < M; j++) {
			for (int k = 1; k < M; k++) {
				map[j][k] = Math.max(map[j - 1][k], Math.max(map[j - 1][k - 1], map[j][k - 1]));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
