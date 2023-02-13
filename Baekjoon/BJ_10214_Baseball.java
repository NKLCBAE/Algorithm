import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10214_BaseBall {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int yonsei = 0;
			int korea = 0;
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				yonsei += Integer.parseInt(st.nextToken());
				korea += Integer.parseInt(st.nextToken());
			}
			if (yonsei > korea) {
				System.out.println("Yonsei");
			} else if (korea > yonsei) {
				System.out.println("Korea");
			} else {
				System.out.println("Draw");
			}
		}
	}

}
