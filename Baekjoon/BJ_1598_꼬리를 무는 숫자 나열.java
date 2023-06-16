import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int xr = ((x-1)/4)+1; //5
        int xc = x%4; //0
        if(xc==0) xc= 4;
        int yr = ((y-1)/4)+1; //10
        int yc = y%4;
        if(yc==0) yc =4;
        System.out.println(Math.abs(xr-yr)+Math.abs(xc-yc));
        

    }

}
