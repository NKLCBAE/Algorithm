import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11365_terceSpoT {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			if (s.equals("END")) {
				break;
			}
			for (int i = s.length() - 1; i >= 0; i--) {
				sb.append(s.charAt(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
