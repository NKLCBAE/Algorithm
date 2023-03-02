import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14890_GyeongSaRo {
	static int[][] map;
	static int N, L;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			garo(i);
			sero(i);
		}
		System.out.println(count);
	}

	private static void garo(int r) {
		boolean[] v = new boolean[N];
		int c = 0;
		while (c < N - 1) {
			c++;
			if (map[r][c] != map[r][c - 1]) {
				if (Math.abs(map[r][c] - map[r][c - 1]) > 1) {
					return;
				}
				if (map[r][c] > map[r][c - 1]) {
					if (v[c - 1])
						return;
					int l = 1;
					Queue<Integer> que = new LinkedList<>();
					que.add(c - 1);
					v[c - 1] = true;
					while (!que.isEmpty()) {
						int cur = que.poll();
						if (l == L)
							break;
						int nc = cur - 1;
						if (nc >= 0 && !v[nc] && map[r][nc] == map[r][cur]) {
							v[nc] = true;
							l++;
							que.add(nc);
						}
					}
					if (l < L)
						return;
				} else if (map[r][c] < map[r][c - 1]) {
					if (v[c])
						return;
					int l = 1;
					Queue<Integer> que = new LinkedList<>();
					que.add(c);
					v[c] = true;
					while (!que.isEmpty()) {
						int cur = que.poll();
						if (l == L)
							break;
						int nc = cur + 1;
						if (nc < N && !v[nc] && map[r][nc] == map[r][cur]) {
							v[nc] = true;
							l++;
							que.add(nc);
						}
					}
					if (l < L)
						return;
				}

			}

		}
		count++;
	}

	private static void sero(int c) {
		boolean[] v = new boolean[N];
		int r = 0;
		while (r < N - 1) {
			r++;
			if (map[r][c] != map[r - 1][c]) {
				if (Math.abs(map[r][c] - map[r - 1][c]) > 1) {
					return;
				}
				if (map[r][c] > map[r - 1][c]) {
					if (v[r - 1])
						return;
					int l = 1;
					Queue<Integer> que = new LinkedList<>();
					que.add(r - 1);
					v[r - 1] = true;
					while (!que.isEmpty()) {
						int cur = que.poll();
						int nr = cur - 1;
						if (l == L)
							break;
						if (nr >= 0 && !v[nr] && map[nr][c] == map[cur][c]) {
							v[nr] = true;
							l++;
							que.add(nr);
						}
					}
					if (l < L)
						return;
				} else if (map[r][c] < map[r - 1][c]) {
					if (v[r])
						return;
					int l = 1;
					Queue<Integer> que = new LinkedList<>();
					que.add(r);
					v[r] = true;
					while (!que.isEmpty()) {
						int cur = que.poll();
						int nr = cur + 1;
						if (l == L)
							break;
						if (nr < N && !v[nr] && map[nr][c] == map[cur][c]) {
							v[nr] = true;
							l++;
							que.add(nr);
						}
					}
					if (l < L)
						return;
				}

			}

		}
		count++;
	}

}
