import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14600_ShowrRoomFloorSpread {
	static int N;
	static int[][] map;
	static int index = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = (int) Math.pow(2, K);
		map = new int[N][N];
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int ex = N - y;
		int ey = x - 1;
		map[ex][ey] = -1;
		if (N == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (map[i][j] == -1)
						continue;
					map[i][j] = index;
				}
			}
		} else {
			first(ex, ey);
			if (map[0][0] == 0) {
				map[0][0] = index;
				map[1][0] = index;
				map[0][1] = index;
				index++;
			}
			if (map[0][3] == 0) {
				map[0][3] = index;
				map[0][2] = index;
				map[1][3] = index;
				index++;
			}
			if (map[3][0] == 0) {
				map[3][0] = index;
				map[3][1] = index;
				map[2][0] = index;
				index++;
			}
			if (map[3][3] == 0) {
				map[3][3] = index;
				map[3][2] = index;
				map[2][3] = index;
				index++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					map[i][j] = index;
				}
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void first(int ex, int ey) {
		boolean left = true;
		boolean up = true;
		if (ex >= N / 2) {
			up = false;
		}
		if (ey >= N / 2) {
			left = false;
		}
		if (up && left) {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (map[i][j] == -1)
						continue;
					map[i][j] = index;
				}
			}
			index++;
			return;
		}
		if (up && !left) {
			for (int i = 0; i < N / 2; i++) {
				for (int j = N / 2; j < N; j++) {
					if (map[i][j] == -1)
						continue;
					map[i][j] = index;
				}
			}
			index++;
			return;
		}
		if (!up && left) {
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (map[i][j] == -1)
						continue;
					map[i][j] = index;
				}
			}
			index++;
			return;
		}
		if (!up && !left) {
			for (int i = N / 2; i < N; i++) {
				for (int j = N / 2; j < N; j++) {
					if (map[i][j] == -1)
						continue;
					map[i][j] = index;
				}
			}
			index++;
			return;
		}
	}

}
