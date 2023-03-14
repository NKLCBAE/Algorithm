import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17406_ArrayRolling_4 {
	static int N, M, K;
	static int min = Integer.MAX_VALUE;
	static int[][] turn;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		turn = new int[K][3];
		v = new boolean[K];
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = Integer.parseInt(st.nextToken());
			turn[i][2] = Integer.parseInt(st.nextToken());
		}
		perm(0, map);
		System.out.println(min);
	}

	private static void perm(int choice, int[][] map) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		if (choice == K) {
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
				min = Math.min(sum, min);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (v[i])
				continue;
			v[i] = true;
			map = turn(i, map);
			perm(choice + 1, map);
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					map[j][k] = temp[j][k];
				}
			}
			v[i] = false;
		}

	}

	private static int[][] turn(int t, int[][] map) {
		int r = turn[t][0] - 1;
		int c = turn[t][1] - 1;
		int s = turn[t][2];
		int sr = r - s;
		int sc = c - s;
		int er = r + s;
		int ec = c + s;
		while (true) {
			int temp = map[sr][sc];
			for (int i = sr; i < er; i++) {
				map[i][sc] = map[i + 1][sc];
			}
			for (int i = sc; i < ec; i++) {
				map[er][i] = map[er][i + 1];
			}
			for (int i = er; i > sr; i--) {
				map[i][ec] = map[i - 1][ec];
			}
			for (int i = ec; i > sc; i--) {
				map[sr][i] = map[sr][i - 1];
			}
			map[sr][sc + 1] = temp;

			sr += 1;
			sc += 1;
			er -= 1;
			ec -= 1;
			if (sr >= er || sc >= ec)
				break;
		}

		return map;
	}

}
