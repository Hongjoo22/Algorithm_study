import java.io.*;
import java.util.*;

public class BJ_2458_키순서 {

	static final int INF = 9999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N]; // 자신보다 큰 노드개수
		int[][] map2 = new int[N][N]; // 자신보다 작은 노드개수
		int count = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c]  = 1;
			map2[c][r] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && i != j) map[i][j] = INF;
				if (map2[i][j] == 0 && i != j) map2[i][j] = INF;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;
				for (int j = 0; j < N; j++) {
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
					if(map2[i][j]>map2[i][k]+map2[k][j]) {
						map2[i][j] = map2[i][k]+map2[k][j];
					}
				}
			}
		}	
		go: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if( map[i][j]==INF && map2[i][j]==INF) continue go;
			}
			count++;
		}			
		System.out.println(count);		
	}
}
