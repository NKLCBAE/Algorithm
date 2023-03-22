import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1159_BasketBallMatch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] name = new int[26];
		for (int i = 0; i < N; i++) {
			name[br.readLine().charAt(0) - 97]++;
		}
		String s = "";
		for (int i = 0; i < name.length; i++) {
			if (name[i] >= 5) {
				s += (char) (i + 97);
			}
		}
		if (s.equals("")) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(s);
		}
	}

}
