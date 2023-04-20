import java.util.*;
import java.io.*;

public class Main
{   
    static int[] tr = {0,1,0,-1};
    static int[] tc = {-1,0,1,0};
    static int[][] dr = {{-2,-1,-1,-1,0,1,1,1,2},{0,1,0,-1,2,1,0,-1,0},{2,1,1,1,0,-1,-1,-1,-2},{0,-1,0,1,-2,-1,0,1,0}}; // l d r u
    static int[][] dc = {{0,-1,0,1,-2,-1,0,1,0},{-2,-1,-1,-1,0,1,1,1,2},{0,1,0,-1,2,1,0,-1,0},{2,1,1,1,0,-1,-1,-1,-2}};
    static int[] dv = {2,10,7,1,5,10,7,1,2};
    static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int i=0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		int total = 0;
		int sand = 0;
		int restsand = 0;
		int r = N/2;
		int c = N/2;
		int d = 0; // 왼쪽부터, 좌 하 우 상
		int l = 1; // 거리 1부터 2, 3 ...
		int temp = 0; // 2번 채웠으면 다시 0으로
		go:
		while(true){
		    for(int i=0; i<l; i++){
		        r = r+tr[d];
		        c = c+tc[d];
		        if(r<0 || c<0){
		            break go;
		        }
		        sand = map[r][c];
		        restsand = map[r][c];
		        map[r][c] = 0;
		        for(int j=0; j<9; j++){
		            int nr = r+dr[d][j];
		            int nc = c+dc[d][j];
		            if(nr>=0 && nr<N && nc>=0 && nc<N){
		               
		                map[nr][nc]+= sand*dv[j]/100;
		                restsand-=sand*dv[j]/100;
		            }
		            else{
		                total+= sand*dv[j]/100;
		                restsand-=sand*dv[j]/100;
		            }
		        }
		        if(r+tr[d]>=0 && r+tr[d]<N && c+tc[d]>=0 && c+tc[d]<N){
		                map[r+tr[d]][c+tc[d]] += restsand;
		            }
		        else{
		                total += restsand;
		        }
		    }
		    d++;
		    temp++;
		    if(d==4){
		        d = 0;
		    }
		    if(temp==2){
		        temp = 0;
		        l++;
		    }
		}
		System.out.println(total);
	}
}
