import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10808_AlphabetGaeSoo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[26];
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 97]++;
		}
		for (int i : count) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}

}
