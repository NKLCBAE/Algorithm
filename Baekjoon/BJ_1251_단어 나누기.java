import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1251_WordDevide {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		PriorityQueue<String> pq = new PriorityQueue<String>();
		for (int i = 1; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String s1 = s.substring(0, i);
				String s2 = s.substring(i, j);
				String s3 = s.substring(j, s.length());
				StringBuilder sb = new StringBuilder();
				for (int k = s1.length() - 1; k >= 0; k--) {
					sb.append(s1.charAt(k));
				}
				for (int k = s2.length() - 1; k >= 0; k--) {
					sb.append(s2.charAt(k));
				}
				for (int k = s3.length() - 1; k >= 0; k--) {
					sb.append(s3.charAt(k));
				}
				pq.add(sb.toString());
			}
		}
		System.out.println(pq.poll());
	}

}
