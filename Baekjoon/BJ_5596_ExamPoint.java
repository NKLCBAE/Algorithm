import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5596_시험점수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int minkuk = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())
				+ Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int manse = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())
				+ Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		System.out.println(Math.max(minkuk, manse));
	}

}
