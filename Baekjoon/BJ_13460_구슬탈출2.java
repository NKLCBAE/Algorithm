import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] v;
	static int count = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int rr, rc, br, bc;
	static boolean cango = false;

	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(BR.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = BR.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					rr = i;
					rc = j;
					map[i][j] = '.';
				}
				if (map[i][j] == 'B') {
					br = i;
					bc = j;
					map[i][j] = '.';
				}
			}
		}
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { rr, rc, br, bc });
		go: while (!que.isEmpty()) {
			int size = que.size();
			count++;
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				int crr = cur[0];
				int crc = cur[1];
				int cbr = cur[2];
				int cbc = cur[3];
				for (int d = 0; d < 4; d++) {
					int nrr = crr + dr[d];
					int nrc = crc + dc[d];
					int nbr = cbr + dr[d];
					int nbc = cbc + dc[d];
					boolean checkR = false;
					boolean checkB = false;
					if (map[nrr][nrc] != '#') {
						checkR = true;
					}
					if (map[nbr][nbc] != '#') {
						checkB = true;
					}
					if (checkR && checkB) {
						int[] afterMoveR = move(crr, crc, cbr, cbc, d);
						int[] afterMoveB = move(cbr, cbc, crr, crc, d);
						if (map[afterMoveB[0]][afterMoveB[1]] != 'O') {
							if (map[afterMoveR[0]][afterMoveR[1]] == 'O') {
								cango = true;
							}
							que.add(new int[] { afterMoveR[0], afterMoveR[1], afterMoveB[0], afterMoveB[1] });
						}

					} else if (checkR) {
						int[] afterMoveR = move(crr, crc, cbr, cbc, d);
						if (map[afterMoveR[0]][afterMoveR[1]] == 'O') {
							cango = true;
						}
						que.add(new int[] { afterMoveR[0], afterMoveR[1], cbr, cbc });
					} else if (checkB) {
						int[] afterMoveB = move(cbr, cbc, crr, crc, d);
						if (map[afterMoveB[0]][afterMoveB[1]] != 'O') {
							que.add(new int[] { crr, crc, afterMoveB[0], afterMoveB[1] });
						}
					}
					if (cango) {
						break go;
					}
				}
			}
			if (count == 10)
				break;

		}
		if (cango) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}

	private static int[] move(int cr, int cc, int xr, int xc, int d) {
		int[] afterMove = new int[2];
		int nr = cr;
		int nc = cc;
		boolean check = false;
		while (true) {
			nr = nr + dr[d];
			nc = nc + dc[d];
			if (map[nr][nc] == '#') {
				nr = nr - dr[d];
				nc = nc - dc[d];
				break;
			}
			if (map[nr][nc] == 'O') {
				afterMove[0] = nr;
				afterMove[1] = nc;
				return afterMove;
			}
			if (nr == xr && nc == xc) {
				check = true;
			}
		}
		if (check) {
			nr = nr - dr[d];
			nc = nc - dc[d];
		}
		afterMove[0] = nr;
		afterMove[1] = nc;
		return afterMove;
	}

}
