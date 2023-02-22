import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map = new char[12][6];
	static int answer = 0;
	static boolean boom = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		while (boom) {
			boom = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == '.')
						continue;
					pang(i, j);
				}
			}
			if (!boom)
				break;
			answer++;
			gravity();
		}
		System.out.println(answer);

	}

	private static void pang(int r, int c) {

		char color = map[r][c];
		boolean[][] v = new boolean[12][6];
		Queue<int[]> que = new LinkedList<>();
		Queue<int[]> yebi = new LinkedList<>();
		v[r][c] = true;
		que.add(new int[] { r, c });
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			yebi.add(cur);
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && map[nr][nc] == color && !v[nr][nc]) {
					v[nr][nc] = true;
					que.add(new int[] { nr, nc });
				}
			}
		}
		if (yebi.size() >= 4) {
			boom = true;
			while (!yebi.isEmpty()) {
				int cur[] = yebi.poll();
				map[cur[0]][cur[1]] = '.';
			}
		}
	}

	private static void gravity() {
		for (int i = 11; i >= 0; i--) {
			for (int j = 5; j >= 0; j--) {
				if (map[i][j] == '.')
					continue;
				down(i, j);
			}
		}

	}

	private static void down(int r, int c) {
		char color = map[r][c];
		boolean floor = true;
		for (int i = r + 1; i < 12; i++) {
			if (map[i][c] != '.') {
				map[r][c] = '.';
				map[i - 1][c] = color;
				floor = false;
				break;
			}
		}
		if (floor) {
			map[r][c] = '.';
			map[11][c] = color;
		}

	}
}
