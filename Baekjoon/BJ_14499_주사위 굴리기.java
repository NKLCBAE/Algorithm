import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_DiceRolling {
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[] dice = { 0, 0, 0, 0, 0, 0 }; // 상, 후, 우 ,전, 좌 , 하
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken());
			x = x + dr[order];
			y = y + dc[order];
			if (x < 0 || x >= N || y < 0 || y >= M) {
				x = x - dr[order];
				y = y - dc[order];
			} else {
				int up = dice[0];
				switch (order) {
				case 1:
					dice[0] = dice[4];
					dice[4] = dice[5];
					dice[5] = dice[2];
					dice[2] = up;
					break;
				case 2:
					dice[0] = dice[2];
					dice[2] = dice[5];
					dice[5] = dice[4];
					dice[4] = up;
					break;
				case 3:
					dice[0] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[1];
					dice[1] = up;
					break;
				case 4:
					dice[0] = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[3];
					dice[3] = up;
					break;
				}
				if (map[x][y] == 0) {
					map[x][y] = dice[5];
				} else {
					dice[5] = map[x][y];
					map[x][y] = 0;
				}
				sb.append(dice[0] + "\n");
			}
		}
		System.out.println(sb);
	}

}
