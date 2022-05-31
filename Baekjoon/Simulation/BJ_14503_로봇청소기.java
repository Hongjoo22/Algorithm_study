import java.io.*;
import java.util.*;

public class BJ_14503_로봇청소기 {

	static int[][] map;
	static int N,M,total;
	static boolean[][] v;
	static int[] dr = {0,1,0,-1}; // 좌 하 우 상
	static int[] dc = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken()); // 초기 위치
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken()); // 초기 방향
		
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		total = 0;
		go(sr,sc,3-sd, 0);
		System.out.println(total);	
	}
	private static void go(int r, int c, int sd, int count) {
		if(!v[r][c]) total++;
		v[r][c] = true;
		for (int d = sd+1; d < sd+5; d++) {
			int nr = r + dr[d%4];
			int nc = c + dc[d%4];
			if(v[nr][nc] || map[nr][nc] == 1) count++;
			else {
				go(nr,nc,d%4,0);
				return;
			}
		}
		if(count==4) { // 뒤가 벽인지 확인
			int nr = r + dr[(sd+2)%4];
			int nc = c + dc[(sd+2)%4];			
			if(map[nr][nc]==1) return;
			else go(nr,nc,sd,0);			
		}
	}
}
