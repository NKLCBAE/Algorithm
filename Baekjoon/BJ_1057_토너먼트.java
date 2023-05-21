import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1057_Tournament {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int round = 1;
		boolean check = false;
		while (N > 1) {
			if (Math.abs(A - B) == 1 && (((A + B) / 2) % 2) == 1) {
				check = true;
				break;
			}
			if (A % 2 == 0) {
				A /= 2;
			} else {
				A = (A + 2) / 2;
			}
			if (B % 2 == 0) {
				B /= 2;
			} else {
				B = (B + 2) / 2;
			}
			if (N % 2 == 0) {
				N /= 2;
			} else {
				N = N / 2 + 1;
			}
			round++;

		}
		if (check) {
			System.out.println(round);
		} else {
			System.out.println(-1);
		}

	}

}
