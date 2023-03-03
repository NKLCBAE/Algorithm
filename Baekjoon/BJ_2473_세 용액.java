import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2473_ThreeDragonLiquid {
	static long[] liquid;
	static long[] ans = new long[3];
	static long max = 3000000000l;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		liquid = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(liquid);
		for (int i = 0; i < N - 2; i++) {
			find(i);
		}
		Arrays.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (long l : ans) {
			sb.append(l + " ");
		}
		System.out.println(sb);
	}

	private static void find(int index) {
		int left = index + 1;
		int right = liquid.length - 1;

		while (left < right) {
			long sum = liquid[left] + liquid[right] + liquid[index];
			if (Math.abs(sum) < max) {
				ans[0] = liquid[left];
				ans[1] = liquid[right];
				ans[2] = liquid[index];
				max = Math.abs(sum);
			}

			if (sum > 0)
				right--;
			else
				left++;
		}

	}

}
