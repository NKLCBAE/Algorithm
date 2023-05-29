import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1357_ReverseSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String X = st.nextToken();
		String Y = st.nextToken();
		boolean check = false;
		String rX = "";
		String rY = "";
		for (int i = X.length() - 1; i >= 0; i--) {
			if (X.charAt(i) == '0') {
				if (check) {
					rX += X.charAt(i);
				}
			} else {
				rX += X.charAt(i);
				check = true;
			}
		}
		check = false;
		for (int i = Y.length() - 1; i >= 0; i--) {
			if (Y.charAt(i) == '0') {
				if (check) {
					rY += Y.charAt(i);
				}
			} else {
				rY += Y.charAt(i);
				check = true;
			}
		}
		int a = Integer.parseInt(rX) + Integer.parseInt(rY);
		String rans = a + "";
		String ans = "";
		check = false;
		for (int i = rans.length() - 1; i >= 0; i--) {
			if (rans.charAt(i) == '0') {
				if (check) {
					ans += rans.charAt(i);
				}
			} else {
				ans += rans.charAt(i);
				check = true;
			}
		}
		System.out.println(ans);
	}

}
