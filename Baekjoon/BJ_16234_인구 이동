import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_PopulationMoving {
	static int[][] map;
	static int[][] map2;
	static int N, L, R;
	static int count = 0;
	static boolean check;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			v = new boolean[N][N];
			map2 = new int[N][N];
			check = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map2[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j]) {
						bfs(i, j);
					}
				}
			}
			if (!check) {
				break;
			}
			count++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map2[i][j];
				}
			}
		}
		System.out.println(count);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		Queue<int[]> temp = new LinkedList<int[]>();
		que.add(new int[] { r, c });
		v[r][c] = true;
		int sum = map[r][c];
		while (!que.isEmpty()) {
			int cur[] = que.poll();
			temp.add(cur);
			int cr = cur[0];
			int cc = cur[1];
			int val = map[cr][cc];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && Math.abs(val - map[nr][nc]) >= L
						&& Math.abs(val - map[nr][nc]) <= R) {
					v[nr][nc] = true;
					que.add(new int[] { nr, nc });
					sum += map[nr][nc];
				}
			}
		}
		if (temp.size() >= 2) {
			check = true;
			int avg = sum / temp.size();
			while (!temp.isEmpty()) {
				int[] cur = temp.poll();
				map2[cur[0]][cur[1]] = avg;
			}
		}

	}

}
