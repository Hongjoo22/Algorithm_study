import java.io.*;
import java.util.*;

public class BJ_1149_RGB거리 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] d = new int[N+1][3];
		d[0][0] = d[0][1] = d[0][2] = 0; 
		// 그 전집에서 선택한 색만 아니면된다
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j==0) {
					d[i][0]  = Math.min(d[i-1][1], d[i-1][2])+map[i-1][0];
				}else if(j==1) {
					d[i][1]  = Math.min(d[i-1][0], d[i-1][2])+map[i-1][1];
				}else {
					d[i][2]  = Math.min(d[i-1][0], d[i-1][1])+map[i-1][2];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, d[N][i]);
		}
		System.out.println(min);
	}
}
