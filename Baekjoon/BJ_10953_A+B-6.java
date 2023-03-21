import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10953_AplusB_6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int A = s.charAt(0) - 48;
			int B = s.charAt(2) - 48;
			sb.append(A + B).append("\n");
		}
		System.out.println(sb);

	}

}
