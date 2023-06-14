import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[]hap = new int[81];
        for(int i=1; i<=a; i++){
            for(int j=1; j<=b; j++){
                for(int k=1; k<=c; k++){
                    hap[i+j+k]++;
                }
            }
        }
        int maxIndex = 0;
        int max = 0;
        for(int i=3; i<=a+b+c; i++){
            if(hap[i]>max){
                max = hap[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }

}
