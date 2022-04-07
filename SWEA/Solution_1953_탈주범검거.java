import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거 {

	static int N,M,L;
	static int[][] map,time;
	static int[] dr = {-1,0,1,0}; // 상 우  하 좌
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken()); // 맨홀 위치
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken()); // 소요시간
			map = new int[N][M];
			time = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			bfs(R,C);
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(time[i][j]!=0) res++;
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
	private static void bfs(int a, int b) {
		Queue<int[]> qu =  new LinkedList<int[]>();
		boolean[][] v = new boolean[N][M];
		qu.add(new int[] {a,b,1});
		v[a][b]=true;
		time[a][b]  = 1;
		
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			if(cnt==L) continue;
			go :for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(v[nr][nc]) continue;
				
				int type = map[nr][nc];
				boolean cango = false;
				if(d==0 && (type==1 || type==2 || type==5 || type ==6)) cango = true;
				else if(d==1 && (type==1 || type==3|| type==6 || type ==7)) cango = true;
				else if(d==2 && (type==1 || type==2 || type==4 || type ==7)) cango = true;
				else if(d==3 && (type==1 || type==3|| type==4 || type ==5)) cango = true;
				
				switch (map[r][c]) {
				case 1: 
					break;
				case 2:
					if(d==1 || d==3) continue go;
					break;
				case 3:
					if(d==0 || d==2) continue go;
					break;
				case 4:
					if(d==2 || d==3) continue go;
					break;
				case 5:
					if(d==0 || d==3) continue go;
					break;
				case 6:
					if(d==0 || d==1) continue go;
					break;
				case 7:
					if(d==1 || d==2) continue go;
					break;
				case 0:
					break go;
				}
				if(map[nr][nc]!=0 && cango) {
					time[nr][nc] = time[r][c]+1;
					qu.add(new int[] {nr,nc,cnt+1});
					v[nr][nc]=true;
				}
			}
		}
	}
}