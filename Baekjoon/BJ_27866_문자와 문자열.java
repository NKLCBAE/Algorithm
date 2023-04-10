import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_27866_CharAndString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(s.charAt(Integer.parseInt(br.readLine()) - 1));
	}

}
