import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17281_BaseBall {
	static int[] nums;
	static int[] order;
	static boolean[] v;
	static int N;
	static int[][] hit;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hit = new int[N][9];
		order = new int[8];
		nums = new int[8];
		v = new boolean[8];
		int index = 0;
		for (int i = 1; i < 9; i++) {
			nums[index++] = i;

		}
		order = new int[8];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				hit[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0, 0);
		System.out.println(max);
	}

	private static void perm(int start, int count) {
		if (count == 8) {
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				if (i == 3) {
					que.add(0);
				}
				que.add(order[i]);
			}
			play(que);
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (v[i])
				continue;
			v[i] = true;
			order[count] = nums[i];
			perm(i + 1, count + 1);
			v[i] = false;
		}

	}

	private static void play(Queue<Integer> que) {
		int inning = 0;
		int point = 0;
		while (inning < N) {
			int out = 0;
			int[] base = new int[3];
			while (true) {
				int cur = que.poll();
				que.add(cur);
				switch (hit[inning][cur]) {
				case 1:
					for (int i = 2; i >= 0; i--) {
						if (base[i] == 1) {
							base[i] = 0;
							if (i + 1 > 2) {
								point++;
							} else {
								base[i + 1] = 1;
							}
						}
					}
					base[0] = 1;
					break;
				case 2:
					for (int i = 2; i >= 0; i--) {
						if (base[i] == 1) {
							base[i] = 0;
							if (i + 2 > 2) {
								point++;
							} else {
								base[i + 2] = 1;
							}
						}
					}
					base[1] = 1;
					break;
				case 3:
					for (int i = 0; i < 3; i++) {
						if (base[i] == 1) {
							point++;
						}
						base[i] = 0;
					}
					base[2] = 1;
					break;
				case 4:
					point++;
					for (int i = 0; i < 3; i++) {
						if (base[i] == 1) {
							point++;
						}
						base[i] = 0;
					}
					break;
				case 0:
					out++;
					break;
				}

				if (out == 3)
					break;
			}
			inning++;
		}
		max = Math.max(max, point);
	}

}
