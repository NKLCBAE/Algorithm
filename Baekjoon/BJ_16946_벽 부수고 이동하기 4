import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;
	static int index = 2;
	static int[] block = new int[1000000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && v[i][j] == false) {
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int temp = 0;
					Set<Integer> set = new HashSet<>();
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
							set.add(map[nr][nc]);
						}
					}
					Iterator<Integer> iter = set.iterator();
					while (iter.hasNext()) {
						temp += block[iter.next()];
					}
					sb.append((temp + 1) % 10);
				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { r, c });
		map[r][c] = index;
		int count = 1;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && v[nr][nc] == false) {
					que.add(new int[] { nr, nc });
					v[nr][nc] = true;
					map[nr][nc] = index;
					count++;
				}
			}
		}
		block[index] = count;
		index++;

	}

}
