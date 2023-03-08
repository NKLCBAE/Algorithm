import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14621_LoveWithoutMe {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] gender = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			if (st.nextToken().charAt(0) == 'M') {
				gender[i] = 0;
			} else {
				gender[i] = 1;
			}
		}
		ArrayList<Load>[] graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (gender[a] == gender[b]) {
				continue;
			}
			graph[a].add(new Load(b, c));
			graph[b].add(new Load(a, c));
		}
		int ans = 0;
		int cnt = 0;
		PriorityQueue<Load> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.value, p2.value));
		boolean[] v = new boolean[N + 1];
		pq.add(new Load(1, 0));
		while (!pq.isEmpty()) {
			Load load = pq.poll();

			if (v[load.node]) {
				continue;
			}
			v[load.node] = true;
			ans += load.value;
			for (Load next : graph[load.node]) {
				if (!v[next.node]) {
					pq.add(next);
				}
			}
			if (++cnt == N) {
				break;
			}
		}
		if (cnt != N) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	public static class Load {
		int node;
		int value;

		Load(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}

}
