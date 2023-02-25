import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11721_TenCutPrint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int index = 0;
		while (true) {
			if (s.length() < index + 10) {
				sb.append(s.substring(index, s.length())).append("\n");
				break;
			}
			sb.append(s.substring(index, index + 10)).append("\n");
			index += 10;
		}
		System.out.println(sb);
	}

}
