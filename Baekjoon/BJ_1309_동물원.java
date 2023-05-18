import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N][3]; // j가 0 일때는 i 줄에 동물 x, 1이면 첫 번째칸에 동물, 2면
                                      // 두번째 칸에 동물 놓았을 때의 경우의 수
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        long answer = (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901;
        System.out.println(answer);

    }

}
