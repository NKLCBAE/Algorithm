import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<int[]> que;
	static ArrayList<int[]> door;
	static char[][] map;
	static int[] keys;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int document;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			document = 0;
			map = new char[R + 2][C + 2];
			v = new boolean[R + 2][C + 2];
			keys = new int[26];
			que = new LinkedList<>();
			door = new ArrayList<>();
			for (int i = 1; i < R + 1; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j + 1] = s.charAt(j);
				}
			}
			for (int i = 0; i < R + 2; i++) {
				map[i][0] = '.';
				map[i][C + 1] = '.';
			}
			for (int i = 0; i < C + 2; i++) {
				map[0][i] = '.';
				map[R + 1][i] = '.';
			}

			String key = br.readLine();
			if (!key.equals("0")) {
				for (int i = 0; i < key.length(); i++) {
					keys[key.charAt(i) - 97] = 1;
				}
			}
			que.add(new int[] { 0, 0 });
			v[0][0] = true;
			while (!que.isEmpty()) {
				int[] cur = que.poll();
				int cr = cur[0];
				int cc = cur[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (nr >= 0 && nr < R + 2 && nc >= 0 && nc < C + 2 && v[nr][nc] == false && map[nr][nc] != '*') {
						if (map[nr][nc] == '.') {
							que.add(new int[] { nr, nc });
							v[nr][nc] = true;
						} else if (map[nr][nc] == '$') {
							document++;
							que.add(new int[] { nr, nc });
							v[nr][nc] = true;
						} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
							keys[map[nr][nc] - 97] = 1;
							que.add(new int[] { nr, nc });
							v[nr][nc] = true;
							doorCheck();
						} else {
							meetDoor(nr, nc);
						}
					}
				}
			}
			sb.append(document + "\n");
		}
		System.out.println(sb);

	}

	private static void doorCheck() {
		int size = door.size();
		int index = 0;
		for (int i = 0; i < size; i++) {
			int[] temp = door.get(index);
			if (keys[map[temp[0]][temp[1]] - 65] == 1) {
				que.add(temp);
				door.remove(index);
				index--;
			}
			index++;
		}
	}

	private static void meetDoor(int i, int j) {
		if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
			if (keys[map[i][j] - 65] == 1) {
				que.add(new int[] { i, j });
			} else {
				door.add(new int[] { i, j });
			}
			v[i][j] = true;
		}
	}

}
