import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1189_ComeBackHome {
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int answer = 0;
	static int R, C, K;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		find(R - 1, 0, 0);
		System.out.println(answer);
	}

	private static void find(int r, int c, int count) {
		v[r][c] = true;
		count++;
		if (r == 0 && c == C - 1) {
			if (count == K) {
				answer++;
			}
			v[r][c] = false;
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && map[nr][nc] == '.') {
				find(nr, nc, count);
				v[nr][nc] = false;
			}
		}

	}

}
