import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stuff = Integer.parseInt(st.nextToken());
            int many = Integer.parseInt(st.nextToken());
            sum+= stuff*many;
        }
        if(total==sum){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
