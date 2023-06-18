import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] size = new Long[N];
        for(int i=0; i<N; i++){
            size[i] = Long.paerLong(st.nextToken());
        }
        Long C = Long.parseLong(br.readLine());
        Long answer = 0;
        for(int i=0; i<N; i++){
            if(size[i]==0) continue;
            Long a = (size[i]/C)+1;
            answer += C*a;
        }
        
    }

}
