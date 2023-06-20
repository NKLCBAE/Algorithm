import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[10001];
        int index = 0;
        for(int i=1; i<=N; i++){
            int T = Integer.parseInt(br.readLine());
            for(int j=0; j<T; j++){
                arr[index++] = i;
            }
        }
        for(int i=0; i<Q; i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(arr[q]).append("\n");
        }
        System.out.println(sb);
        
    }

}
