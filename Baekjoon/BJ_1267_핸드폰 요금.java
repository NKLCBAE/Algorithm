import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int Y = 0;
        int M = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
            Y+=(temp/30+1)*10;
            M+=(temp/60+1)*15;
		}
        if(Y>M){
            System.out.println("M "+M);
        }
        else if(Y<M){
            System.out.println("Y "+Y);
        }
        else{
            System.out.println("Y M "+M);
        }
	}

}
