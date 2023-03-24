import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4299_AFCWimbledon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		int a = sum;
		int b = 0;
		while (true) {
			if (a - b == sub) {
				break;
			}
			a--;
			b++;
			if (a == 0) {
				break;
			}
		}
		if (a == 0 && b != 0) {
			System.out.println(-1);
		} else {
			System.out.println(a + " " + b);
		}

	}

}
