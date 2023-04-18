import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10039_AveragePoint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		for (int i = 0; i < 5; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp<40) {
				total+=40;
			}
			else {
				total+=temp;
			}
		}
		System.out.println(total/5);
	}

}
