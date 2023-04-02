import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5524_CheckInManagement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(br.readLine().toLowerCase()).append("\n");
		}
		System.out.println(sb);
	}

}
