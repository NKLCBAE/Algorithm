import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17779_Gerrymandering {
	static int N;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static int total = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		for (int x = 1; x <= N - 2; x++) {
			for (int y = 2; y <= N - 1; y++) {
				find(x, y);
			}
		}
		System.out.println(answer);
	}

	private static void find(int r, int c) {
		for (int d1 = 1; d1 <= c - 1; d1++) {
			for (int d2 = 1; r + d1 + d2 <= N && d1 + 1 <= c && d2 + c <= N; d2++) {
				devide(r, c, d1, d2);
			}
		}

	}

	private static void devide(int r, int c, int d1, int d2) {
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int E = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		int[][] goo = new int[N][N];
		for (int i = 0; i <= d1; i++) {
			goo[r - 1 + i][c - 1 - i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			goo[r - 1 + i][c - 1 + i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			goo[r - 1 + d1 + i][c - 1 - d1 + i] = 5;
		}
		for (int i = 0; i <= d1; i++) {
			goo[r - 1 + d2 + i][c - 1 + d2 - i] = 5;
		}
		// 1
		for (int i = 0; i < r - 1 + d1; i++) {
			for (int j = 0; j < c; j++) {
				if (goo[i][j] == 5)
					break;
				goo[i][j] = 1;
				A += map[i][j];
			}
		}
		// 2
		for (int i = 0; i <= r - 1 + d2; i++) {
			for (int j = N - 1; j >= c; j--) {
				if (goo[i][j] == 5)
					break;
				goo[i][j] = 2;
				B += map[i][j];
			}
		}
		// 3
		for (int i = r - 1 + d1; i < N; i++) {
			for (int j = 0; j < c - 1 - d1 + d2; j++) {
				if (goo[i][j] == 5)
					break;
				goo[i][j] = 3;
				C += map[i][j];
			}
		}
		// 4
		for (int i = r + d2; i < N; i++) {
			for (int j = N - 1; j >= c - 1 + d2 - d1; j--) {
				if (goo[i][j] == 5)
					break;
				goo[i][j] = 4;
				D += map[i][j];
			}
		}
		E = total - A - B - C - D;
		int[] arr = { A, B, C, D, E };
		Arrays.sort(arr);
		answer = Math.min(answer, arr[4] - arr[0]);
	}

}
