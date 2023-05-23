import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_27110_SpecialDistribute {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp > N) {
				answer += N;
			} else {
				answer += temp;
			}
		}
		System.out.println(answer);
	}

}
