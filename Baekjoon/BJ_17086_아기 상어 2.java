import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_BabyShark2 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M;
	static int[][] map;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		System.out.println(max);

	}

	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		v[r][c] = true;
		int count = 0;
		que.add(new int[] { r, c });
		go: while (!que.isEmpty()) {
			count++;
			int size = que.size();
			for (int k = 0; k < size; k++) {
				int[] cur = que.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int d = 0; d < 8; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && v[nr][nc] == false) {
						if (map[nr][nc] == 0) {
							v[nr][nc] = true;
							que.add(new int[] { nr, nc });
						} else {
							break go;
						}
					}
				}
			}
		}
		max = Math.max(max, count);
	}

}
