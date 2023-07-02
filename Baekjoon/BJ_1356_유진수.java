import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if (s.length() == 1) {
			System.out.println("NO");
			return;
		}
		for (int i = 1; i < s.length(); i++) {
			int a = 1;
			for (int j = 0; j < i; j++) {
				a *= s.charAt(j) - 48;
			}
			int b = 1;
			for (int j = i; j < s.length(); j++) {
				b *= s.charAt(j) - 48;
			}
			if (a == b) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
