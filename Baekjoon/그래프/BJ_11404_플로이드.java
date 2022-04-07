import java.io.*;
import java.util.*;

public class BJ_11404_플로이드 {

	static final int INF = 99999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			if(map[a][b]==0) {
				map[a][b]=c;
			}else if(map[a][b]!=0 && c<map[a][b]) { // 현재비용이 작으면 갱신
				map[a][b]=c;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0 && i!=j) map[i][j] = INF; 
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || i==j) continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==INF) map[i][j]=0;
				sb.append(map[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
